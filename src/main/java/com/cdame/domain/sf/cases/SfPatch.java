package com.cdame.domain.sf.cases;

import java.util.Date;

import com.cdame.domain.sf.tech.SalesForceObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class SfPatch extends SalesForceObject {

	@JsonProperty(value = "CreatedDate", access = Access.WRITE_ONLY)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdDatetime;
	
	@JsonProperty(value = "CreatedById", access = Access.WRITE_ONLY)
	private String authorId;
	
    @JsonProperty(value = "Description__c", access = Access.WRITE_ONLY)
	private String description;

    @JsonProperty(value = "InstallationProcedure__c", access = Access.WRITE_ONLY)
	private String installationProcedure;

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstallationProcedure() {
		return installationProcedure;
	}

	public void setInstallationProcedure(String installationProcedure) {
		this.installationProcedure = installationProcedure;
	}
}
