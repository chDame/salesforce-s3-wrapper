package com.cdame.domain.sf;

import java.util.List;
import java.util.Map;

import com.cdame.domain.sf.tech.SalesForceObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SfAccount extends SalesForceObject {
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("PhotoUrl")
	private String photoUrl;
	@JsonProperty("IsCustomerPortal")
	private boolean isCustomerPortal;
	@JsonProperty("Active_Subscriptions__c")
	private Integer activeSubscriptions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public boolean isCustomerPortal() {
		return isCustomerPortal;
	}

	public void setCustomerPortal(boolean isCustomerPortal) {
		this.isCustomerPortal = isCustomerPortal;
	}

	public Integer getActiveSubscriptions() {
		return activeSubscriptions;
	}

	public void setActiveSubscriptions(Integer activeSubscriptions) {
		this.activeSubscriptions = activeSubscriptions;
	}
	
}
