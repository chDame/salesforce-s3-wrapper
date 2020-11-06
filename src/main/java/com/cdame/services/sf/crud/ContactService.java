package com.cdame.services.sf.crud;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.cdame.domain.Contact;
import com.cdame.domain.sf.SfContact;
import com.cdame.domain.technical.SOQLQueryResponse;
import com.cdame.exception.CpTechnicalException;
import com.cdame.exception.SalesForceException;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Service
public class ContactService extends SalesForceGenericCrud<SfContact, Contact>{

	@Override
	public String getSfName() {
		return "Contact";
	}
	
	LoadingCache<String, byte[]> userPhoto = CacheBuilder.newBuilder()
			.expireAfterAccess(2, TimeUnit.HOURS)
 	        .build(new CacheLoader<String, byte[]>() {
 	            @Override
 	            public byte[] load(String id) {
 	            	try {
 	            		Contact c = getNormalizedObject(id);
 	            		return salesForceService.get(salesForceService.getInstance()+c.getPhotoUrl(), byte[].class);
					} catch (CpTechnicalException | SalesForceException e) {
						return null;
					}
 	            }
 	        });
	
	public final Contact getContactByMail(String email) throws CpTechnicalException {
		SOQLQueryResponse sOQLQueryResponse = (SOQLQueryResponse) salesForceService.executeQuery("select id from Contact where email = '"+email+"'");

		return getNormalizedObject((String) sOQLQueryResponse.getRecords().get(0).get("Id"));
	}
	
	public final byte[] getContactPhoto(String contactId) throws CpTechnicalException {
		try {
			return userPhoto.get(contactId);
		} catch (ExecutionException e) {
			throw new CpTechnicalException(e);
		}
	}
}
