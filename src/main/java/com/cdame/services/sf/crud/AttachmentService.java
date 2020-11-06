package com.cdame.services.sf.crud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cdame.domain.Attachment;
import com.cdame.domain.CaseComment;
import com.cdame.domain.sf.cases.SfAttachment;
import com.cdame.domain.technical.SOQLQueryResponse;
import com.cdame.exception.CpTechnicalException;

@Deprecated
@Service
public class AttachmentService extends SalesForceGenericCrud<SfAttachment, Attachment>{

	@Override
	public String getSfName() {
		return "Attachment";
	}
	
	public List<Attachment> getAttachments(String parentId) throws CpTechnicalException {
		List<Attachment> result = new ArrayList<>();
		Object soqlResponse = salesForceService.executeQuery("SELECT id FROM Attachment where ParentId = '"+parentId+"'");
		if (soqlResponse instanceof SOQLQueryResponse) {
			SOQLQueryResponse sOQLQueryResponse = (SOQLQueryResponse) soqlResponse;

			for(Map<String, Object> record : sOQLQueryResponse.getRecords()) {
				result.add(getNormalizedObject((String) record.get("Id")));
			}
		}
		return result;
	}
	
	
}
