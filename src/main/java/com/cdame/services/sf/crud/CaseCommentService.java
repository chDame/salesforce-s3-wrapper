package com.cdame.services.sf.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cdame.domain.CaseComment;
import com.cdame.domain.sf.cases.SfCaseComment;
import com.cdame.domain.technical.SOQLQueryResponse;
import com.cdame.exception.CpTechnicalException;

@Deprecated
@Service
public class CaseCommentService extends SalesForceGenericCrud<SfCaseComment, CaseComment>{

	@Override
	public String getSfName() {
		return "CaseComment__c";
	}
	
	public List<CaseComment> getCaseComments(String caseId) throws CpTechnicalException {
		List<CaseComment> result = new ArrayList<>();
		Object soqlResponse = salesForceService.executeQuery("SELECT id FROM CaseComment__c where Case__c = '"+caseId+"'");
		if (soqlResponse instanceof SOQLQueryResponse) {
			SOQLQueryResponse sOQLQueryResponse = (SOQLQueryResponse) soqlResponse;

			for(Map<String, Object> record : sOQLQueryResponse.getRecords()) {
				result.add(getNormalizedObject((String) record.get("Id")));
			}
		}
		return result;
	}
	
}
