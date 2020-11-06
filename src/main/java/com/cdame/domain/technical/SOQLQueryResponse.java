package com.cdame.domain.technical;

import java.util.List;
import java.util.Map;

public class SOQLQueryResponse {

	private int totalSize;
	private boolean done;
	private List<Map<String, Object>> records;
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public List<Map<String, Object>> getRecords() {
		return records;
	}
	public void setRecords(List<Map<String, Object>> records) {
		this.records = records;
	}
	
	
	
}
