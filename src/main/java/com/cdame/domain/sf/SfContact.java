package com.cdame.domain.sf;

import java.util.List;
import java.util.Map;

import com.cdame.domain.sf.tech.SalesForceObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SfContact extends SalesForceObject {

	@JsonProperty("Id")
	private String id;
	@JsonProperty("Email")
	private String email;
	@JsonProperty("FirstName")
	private String firstName;
	@JsonProperty("LastName")
	private String lastName;
	@JsonProperty("AccountId")
	private String accountId;
	@JsonProperty("PhotoUrl")
	private String photoUrl;
	@JsonProperty("AccountHasSubscription__c")
	private Boolean accountHasSubscription;
	@JsonProperty("Profile__c")
	private String profileId;

	private SfAccount account;

	private List<SfSubscription> subscriptions;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public boolean isAccountHasSubscription() {
		return accountHasSubscription;
	}

	public void setAccountHasSubscription(boolean accountHasSubscription) {
		this.accountHasSubscription = accountHasSubscription;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public SfAccount getAccount() {
		return account;
	}

	public void setAccount(SfAccount account) {
		this.account = account;
	}

	public List<SfSubscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<SfSubscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	
}
