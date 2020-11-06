package com.cdame.domain.sf.tech;

public class Errors {
	private String message;
	private String errorCode;
	private String[] fields;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String[] getFields() {
		return fields;
	}
	public void setFields(String[] fields) {
		this.fields = fields;
	}
	
	
}
