package com.cdame.domain;

import java.util.Date;

public class Attachment {

	private String id;
	
	private Date createdDatetime;
	
	private String name;
	
	private String bucket;
	
	private String key;
	
	private Long contentLength;
	
	private String contentType;
	
	private String ownerId;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getContentLength() {
		return contentLength;
	}

	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
}
