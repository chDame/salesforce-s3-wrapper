package com.cdame.domain.sf.tech;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public abstract class SalesForceObject {

	@JsonProperty(value="Id", access = Access.WRITE_ONLY)
	private String id;

	@JsonIgnore
	private Errors[] errors;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Errors[] getErrors() {
		return errors;
	}

	public void setErrors(Errors[] errors) {
		this.errors = errors;
	}
	
}
