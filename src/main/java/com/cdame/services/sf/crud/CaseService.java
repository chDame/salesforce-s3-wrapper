package com.cdame.services.sf.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cdame.domain.Case;
import com.cdame.domain.sf.cases.SfCase;
import com.cdame.domain.technical.SOQLQueryResponse;
import com.cdame.exception.CpTechnicalException;

@Deprecated
@Service
public class CaseService extends SalesForceGenericCrud<SfCase, Case>{

	@Override
	public String getSfName() {
		return "Case";
	}

	public List<Case> getCasesBySubscription(String subscriptionId) throws CpTechnicalException {
		List<Case> result = new ArrayList<>();
		Object soqlResponse = (SOQLQueryResponse) salesForceService.executeQuery("SELECT id FROM Case where subscription__c = '"+subscriptionId+"'");
		if (soqlResponse instanceof SOQLQueryResponse) {
			SOQLQueryResponse sOQLQueryResponse = (SOQLQueryResponse) soqlResponse;
			for(Map<String, Object> record : sOQLQueryResponse.getRecords()) {
				result.add(getNormalizedObject((String) record.get("Id")));
			}
		}
		return result;
	}
}
