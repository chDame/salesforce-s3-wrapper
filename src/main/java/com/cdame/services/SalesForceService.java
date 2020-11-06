package com.cdame.services;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.cdame.domain.sf.tech.Errors;
import com.cdame.domain.technical.SOQLQueryResponse;
import com.cdame.domain.technical.SObjectsResponse;
import com.cdame.domain.technical.Sobject;
import com.cdame.exception.SalesForceException;
import com.cdame.utils.JsonUtils;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Service
public class SalesForceService {
	
    static final String SERVICE_DATA = "/services/data/";
    		
    @Value("${salesForceProperties.username}")
	private String username;
    @Value("${salesForceProperties.password}")
	private String password;
    @Value("${salesForceProperties.secretKey}")
	private String secretKey;
    @Value("${salesForceProperties.loginUrl}")
	private String loginUrl;
    @Value("${salesForceProperties.clientId}")
	private String clientId;
    @Value("${salesForceProperties.clientSecret}")
	private String clientSecret;
    
    @Bean
    private RestTemplate getRestTemplate() {
    	RestTemplate rt = new RestTemplate();
    	rt.getInterceptors().add(new SalesForceEncoderInterceptor());
    	return rt;
    }
    
    @Autowired
    private RestTemplate restTemplate;
    Cache<String, String> salesForceTechCache = CacheBuilder.newBuilder()
			.expireAfterAccess(4, TimeUnit.HOURS)
 	        .build();
   
    private String instance = null;
    
	private final String getAuthorization() {
		if (salesForceTechCache.getIfPresent("token")!=null) {
			return salesForceTechCache.getIfPresent("token");
		}
        // Assemble the login request URL
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "password");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("username", username);
        map.add("password", password+secretKey);
        
        // Login requests must be POSTs
        Map<String, String> tokenBody = restTemplate.postForObject(loginUrl, map, Map.class);
        String token =  tokenBody.get("token_type")+" "+tokenBody.get("access_token");
        salesForceTechCache.put("token", token);
        instance = tokenBody.get("instance_url");
        return token;
	}
	
	public String getInstance() {
		if (instance==null) {
			getAuthorization();
		}
		return instance;
	}
	
	public final HttpHeaders getAuthorizedHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", getAuthorization());
		
		return headers;
	}
	
	public final String getLastApiVersionUrl() {
		if (salesForceTechCache.getIfPresent("lastApiVersionUrl")!=null) {
			return salesForceTechCache.getIfPresent("lastApiVersionUrl");
		}

		HttpEntity<String> entity = new HttpEntity<String>(getAuthorizedHeaders());
		ResponseEntity<List<Map<String, String>>> response = restTemplate.exchange(instance+SERVICE_DATA, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Map<String, String>>>(){});
		String lastApiVersionUrl = null;
		Double lastApiVersion = 0D;
		for(Map<String, String> map : response.getBody()) {
			Double newApiVersion = Double.valueOf(map.get("version"));
			if (newApiVersion>lastApiVersion) {
				lastApiVersion = newApiVersion;
				lastApiVersionUrl = map.get("url");
			}
		}
		salesForceTechCache.put("lastApiVersionUrl", lastApiVersionUrl);
		return lastApiVersionUrl;
	}
	
	public final List<Sobject> getAvailableObjects() {
		HttpEntity<String> entity = new HttpEntity<String>(getAuthorizedHeaders());
		ResponseEntity<SObjectsResponse> response = restTemplate.exchange(instance+getLastApiVersionUrl()+"/sobjects/", HttpMethod.GET, entity, SObjectsResponse.class);
		return response.getBody().getSobjects();
	}
	
	public final Object executeQuery(String query) {
		HttpEntity<String> entity = new HttpEntity<String>(getAuthorizedHeaders());
		try {
			ResponseEntity<SOQLQueryResponse> response = restTemplate.exchange(instance+getLastApiVersionUrl()+"/query/?t=1&q="+query, HttpMethod.GET, entity, SOQLQueryResponse.class);
			//ResponseEntity<SOQLQueryResponse> response = restTemplate.exchange(instance+getLastApiVersionUrl()+"/query/?q="+URLEncoder.QUERY.encode(query, Charset.defaultCharset()), HttpMethod.GET, entity, SOQLQueryResponse.class);
			return response.getBody();
		}  catch (HttpStatusCodeException e) {
			return JsonUtils.toObject(e.getResponseBodyAsByteArray(),  Errors[].class);
		}
	}
	
	public final <T> T get(String url, Class<T> type) throws SalesForceException {
		HttpEntity<String> entity = new HttpEntity<String>(getAuthorizedHeaders());
		try {
			ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, type);
			return response.getBody();
		}  catch (HttpStatusCodeException e) {
			throw new SalesForceException(e.getMessage());
		}
	}
	
	/*
	public final <T extends SalesForceObject> T getObject(SfObjectsEnum sfObjectType, String id, Class<T> type) {

		HttpEntity<String> entity = new HttpEntity<String>(getAuthorizedHeaders());
		try {
			ResponseEntity<T> response = restTemplate.exchange(instance+getLastApiVersionUrl()+"/sobjects/"+
					sfObjectType.getSfName()+"/"+id, HttpMethod.GET, entity, type);
			return response.getBody();
		}  catch (HttpStatusCodeException e) {
			try {
				T result = type.newInstance();
				result.setErrors( JsonUtils.toObject(e.getResponseBodyAsByteArray(),  Errors[].class));
			} catch (InstantiationException | IllegalAccessException e1) {
				
			}
		}
		return null;
	}	*/
	
	public final Object getObject(String name, String id) {

		HttpEntity<String> entity = new HttpEntity<String>(getAuthorizedHeaders());
		try {
			ResponseEntity<Map<String, Object>> response = restTemplate.exchange(instance+getLastApiVersionUrl()+"/sobjects/"+
					name+"/"+id, HttpMethod.GET, entity, new ParameterizedTypeReference<Map<String, Object>>() {});
			return response.getBody();
		}  catch (HttpStatusCodeException e) {
			return JsonUtils.toObject(e.getResponseBodyAsByteArray(),  Errors[].class);
		}
	}	
	/*
	
	public final <T extends SalesForceObject> T insert(SfObjectsEnum sfObjectType, SalesForceObject o, Class<T> type) throws SalesForceException {
		HttpHeaders headers = getAuthorizedHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(JsonUtils.toJSON(o), headers);

		try {
			ResponseEntity<Map<String, Object>> response = restTemplate.exchange(instance+getLastApiVersionUrl()+"/sobjects/"+
					objectName+"/", HttpMethod.POST, entity, new ParameterizedTypeReference<Map<String, Object>>(){});
			Map<String, Object> result = response.getBody();
			if ((boolean) result.get("status")) {
				return getObject(objectName, (String) result.get("id"));
			} else {
				return null;
			}
		}  catch (HttpStatusCodeException e) {
			throw new SalesForceException(JsonUtils.toObject(e.getResponseBodyAsByteArray(),  Errors[].class));
		}
	}
	
	public final <T extends SalesForceObject> T  update(SfObjectsEnum sfObjectType, SalesForceObject o, Class<T> type) throws SalesForceException {
		HttpHeaders headers = getAuthorizedHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(JsonUtils.toJSON(o), headers);

		try {
			ResponseEntity<String> response = restTemplate.exchange(instance+getLastApiVersionUrl()+"/sobjects/"+
					objectName+"/"+o.getId()+ "?_HttpMethod=PATCH", HttpMethod.POST, entity, String.class);
			if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
				return getObject(objectName, o.getId(), type);
			} else {
				return null;
			}
		}  catch (HttpStatusCodeException e) {
			throw new SalesForceException(JsonUtils.toObject(e.getResponseBodyAsByteArray(),  Errors[].class));
		}
	}
	*/
}
