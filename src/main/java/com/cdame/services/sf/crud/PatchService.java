package com.cdame.services.sf.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cdame.domain.Patch;
import com.cdame.domain.sf.cases.SfPatch;
import com.cdame.domain.technical.SOQLQueryResponse;
import com.cdame.exception.CpTechnicalException;

@Deprecated
@Service
public class PatchService extends SalesForceGenericCrud<SfPatch, Patch> {

	@Override
	public String getSfName() {
		return "Patch__c";
	}
	
	public List<Patch> getCasePatches(String caseId) throws CpTechnicalException {
		List<Patch> result = new ArrayList<>();
		Object soqlResponse = salesForceService.executeQuery("SELECT Patch__c FROM PatchCase__c where Case__c = '"+caseId+"'");
		if (soqlResponse instanceof SOQLQueryResponse) {
			SOQLQueryResponse sOQLQueryResponse = (SOQLQueryResponse) soqlResponse;

			for(Map<String, Object> record : sOQLQueryResponse.getRecords()) {
				result.add(getNormalizedObject((String) record.get("Patch__c")));
			}
		}
		return result;
	}

	
}
