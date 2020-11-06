package com.cdame.domain.technical;

import java.util.List;

public class SObjectsResponse {

	private String encoding;
	private Integer maxBatchSize;
	private List<Sobject> sobjects;
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public Integer getMaxBatchSize() {
		return maxBatchSize;
	}
	public void setMaxBatchSize(Integer maxBatchSize) {
		this.maxBatchSize = maxBatchSize;
	}
	public List<Sobject> getSobjects() {
		return sobjects;
	}
	public void setSobjects(List<Sobject> sobjects) {
		this.sobjects = sobjects;
	}
	
	
	
}
