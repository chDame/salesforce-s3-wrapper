package com.cdame.domain;

import java.util.List;

import com.cdame.domain.sf.SfSubscription;

public class Account {

	private String id;
	private String name;
	private String type;
	private String photoUrl;
	private boolean isCustomerPortal;
	private Integer activeSubscriptions;
	private List<SfSubscription> subscriptions;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public List<SfSubscription> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<SfSubscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	
}
