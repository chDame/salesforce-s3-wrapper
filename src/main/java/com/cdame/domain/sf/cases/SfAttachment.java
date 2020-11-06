package com.cdame.domain.sf.cases;

import java.util.Date;

import com.cdame.domain.sf.tech.SalesForceObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SfAttachment extends SalesForceObject {

	@JsonProperty("CreatedDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdDatetime;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Bucket")
	private String bucket;
	@JsonProperty("Key")
	private String key;
	@JsonProperty("BodyLength")
	private Long contentLength;
	@JsonProperty("ContentType")
	private String contentType;
	@JsonProperty("OwnerId")
	private String ownerId;

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
