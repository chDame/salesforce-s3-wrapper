package com.cdame.domain;

import java.util.Date;
import java.util.List;

public class Patch {
	
	private String id;

	private Date createdDatetime;

	private String authorId;

	private String description;

	private String installationProcedure;
	
	private List<Attachment> attachments;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
}
