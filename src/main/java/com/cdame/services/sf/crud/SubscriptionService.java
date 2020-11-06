package com.cdame.services.sf.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cdame.domain.Subscription;
import com.cdame.domain.sf.SfSubscription;
import com.cdame.domain.technical.SOQLQueryResponse;
import com.cdame.exception.CpTechnicalException;

@Service
public class SubscriptionService extends SalesForceGenericCrud<SfSubscription, Subscription>{

	@Override
	public String getSfName() {
		return "Subscription__c";
	}

	public List<Subscription> getSubscriptionsByContact(String contactId) throws CpTechnicalException {
		List<Subscription> result = new ArrayList<>();
		SOQLQueryResponse sOQLQueryResponse = (SOQLQueryResponse) salesForceService.executeQuery("select Subscription__c from SubscriptionAccess__c where Contact__c = '"+contactId+"'");
		for(Map<String, Object> record : sOQLQueryResponse.getRecords()) {
			result.add(getNormalizedObject((String) record.get("Subscription__c")));
		}
		return result;
	}
}
