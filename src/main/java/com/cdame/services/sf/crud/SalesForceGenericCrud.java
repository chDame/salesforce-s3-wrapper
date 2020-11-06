package com.cdame.services.sf.crud;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.cdame.domain.picklist.PickListField;
import com.cdame.domain.picklist.SfObjectDescribe;
import com.cdame.domain.sf.tech.Errors;
import com.cdame.domain.sf.tech.SalesForceObject;
import com.cdame.exception.CpTechnicalException;
import com.cdame.exception.SalesForceException;
import com.cdame.services.SalesForceService;
import com.cdame.utils.JsonUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public abstract class SalesForceGenericCrud<S extends SalesForceObject, N> {

	@Autowired
	SalesForceService salesForceService;
	@Autowired
	RestTemplate restTemplate;

	LoadingCache<String, N> normalizedObjectCache = CacheBuilder.newBuilder()
			.maximumSize(100)
			.expireAfterAccess(2, TimeUnit.HOURS)
			.build(new CacheLoader<String, N>() {
				@Override
				public N load(String id) {
					try {
						return toNormalized(getObject(id));
					} catch (CpTechnicalException e) {
						return null;
					}
				}
			});

	Cache<String, PickListField> pickLists = CacheBuilder.newBuilder()
			.expireAfterAccess(12, TimeUnit.HOURS)
			.build();

	Map<String, String> sfFieldToNomalizedMap = new HashMap<>();
	
	private Class<S> sfClass;
	private Class<N> normalizedClass;

	@PostConstruct
	@SuppressWarnings("unchecked")
	public void init() {
		this.sfClass = (Class<S>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.normalizedClass = (Class<N>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
	}

	public N getNormalizedObject(String id) throws CpTechnicalException {
		try {
			return normalizedObjectCache.get(id);
		} catch (ExecutionException e) {
			throw new CpTechnicalException(e.getLocalizedMessage());
		}
	}

	public final S getObject(String id) {

		HttpEntity<String> entity = new HttpEntity<String>(salesForceService.getAuthorizedHeaders());
		try {
			ResponseEntity<S> response = restTemplate.exchange(salesForceService.getInstance()+salesForceService.getLastApiVersionUrl()+"/sobjects/"+
					getSfName()+"/"+id, HttpMethod.GET, entity, this.sfClass);
			return response.getBody();
		}  catch (HttpStatusCodeException e) {
			try {
				S result = this.sfClass.newInstance();
				result.setErrors( JsonUtils.toObject(e.getResponseBodyAsByteArray(),  Errors[].class));
			} catch (InstantiationException | IllegalAccessException e1) {

			}
		}
		return null;
	}	

	public N insert(N o) throws SalesForceException, CpTechnicalException {
		S sObject = toSf(o);
		sObject = insert(sObject);
		N result = toNormalized(sObject);
		normalizedObjectCache.put(sObject.getId(), result);
		return result;
	}

	public S insert(S o) throws SalesForceException {
		HttpHeaders headers = salesForceService.getAuthorizedHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(JsonUtils.toJSON(o), headers);

		try {
			ResponseEntity<Map<String, Object>> response = restTemplate.exchange(salesForceService.getInstance()+salesForceService.getLastApiVersionUrl()+"/sobjects/"+
					getSfName()+"/", HttpMethod.POST, entity, new ParameterizedTypeReference<Map<String, Object>>(){});
			Map<String, Object> result = response.getBody();
			if ((boolean) result.get("success")) {
				return getObject((String) result.get("id"));
			} else {
				return null;
			}
		}  catch (HttpStatusCodeException e) {
			throw new SalesForceException(JsonUtils.toObject(e.getResponseBodyAsByteArray(),  Errors[].class));
		}
	}	

	public N update(N o) throws SalesForceException, CpTechnicalException {
		S sObject = toSf(o);
		sObject = update(sObject);
		N result = toNormalized(sObject);
		normalizedObjectCache.put(sObject.getId(), result);
		return result;
	}

	public S update(S o) throws SalesForceException {
		HttpHeaders headers = salesForceService.getAuthorizedHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(JsonUtils.toJSON(o), headers);

		try {
			ResponseEntity<String> response = restTemplate.exchange(salesForceService.getInstance()+salesForceService.getLastApiVersionUrl()+"/sobjects/"+
					getSfName()+"/"+o.getId()+ "?_HttpMethod=PATCH", HttpMethod.POST, entity, String.class);
			if (response.getStatusCode().is2xxSuccessful()) {
				return getObject(o.getId());
			} else {
				return null;
			}
		}  catch (HttpStatusCodeException e) {
			throw new SalesForceException(JsonUtils.toObject(e.getResponseBodyAsByteArray(),  Errors[].class));
		}
	}

	public abstract String getSfName();

	public N toNormalized(S source) throws CpTechnicalException {
		try {
			N target = normalizedClass.newInstance();
			BeanUtils.copyProperties(source, target);
			return target;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new CpTechnicalException(e.getMessage());
		}
	}

	public S toSf(N source) throws CpTechnicalException {
		try {
			S target = sfClass.newInstance();
			BeanUtils.copyProperties(source, target);
			return target;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new CpTechnicalException(e.getMessage());
		}
	}

	public PickListField getPickList(String fieldName) {
		PickListField field = pickLists.getIfPresent(fieldName);
		if (field!=null) {
			return field;
		}
		reloadPickLists();
		field = pickLists.getIfPresent(fieldName);
		if (field==null) {
			throw new IllegalArgumentException("Field "+fieldName+" doesn't exist in Salesforce object "+getSfName());
		}
		return field;
	}

	public synchronized void reloadPickLists() {
		HttpHeaders headers = salesForceService.getAuthorizedHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(headers);


		ResponseEntity<SfObjectDescribe> response = restTemplate.exchange(salesForceService.getInstance()+salesForceService.getLastApiVersionUrl()+"/sobjects/"+
				getSfName()+"/describe", HttpMethod.GET, entity, SfObjectDescribe.class);
		if (response.getStatusCode().is2xxSuccessful()) {
			List<PickListField> fields = response.getBody().getFields();
			for (PickListField field : fields) {
				if (field.getPicklistValues()!=null && field.getPicklistValues().size()>0) {
					String normalizedFieldName = getNormalizedFieldName(field.getName());
					if (normalizedFieldName!=null) {
						pickLists.put(getNormalizedFieldName(field.getName()), field);
					}
				}
			}
		} else {
			throw new IllegalArgumentException("Problem describing object "+getSfName()+" in Salesforce");
		}
	}
	
	private synchronized void loadNormalizedField() {
		Field[] fields = sfClass.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(JsonProperty.class)) {
				JsonProperty annotation =  f.getAnnotation(JsonProperty.class);
				sfFieldToNomalizedMap.put(annotation.value(), f.getName());
			} else {
				sfFieldToNomalizedMap.put(f.getName(), f.getName());
			}
		}
	}
	
	public String getNormalizedFieldName(String sfFieldName) {
		if (sfFieldToNomalizedMap.isEmpty()) {
			loadNormalizedField();
		}
		return sfFieldToNomalizedMap.get(sfFieldName);
	}
}
