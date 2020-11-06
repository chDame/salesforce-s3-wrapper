package com.cdame.domain.sf.cases;

import java.util.Date;
import java.util.Map;

import com.cdame.domain.sf.tech.SalesForceObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class SfCaseComment extends SalesForceObject {

	@JsonProperty("CreatedBy__c")
	private String authorId;
	
	@JsonProperty(value = "CreatedDate__c", access = Access.WRITE_ONLY)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdDatetime;
	
	@JsonProperty("CommentBody__c")
	private String body;

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
