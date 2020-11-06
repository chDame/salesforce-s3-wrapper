package com.cdame.domain;

import java.util.List;
import java.util.Map;

public class Contact {

	private String id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String accountId;
	
	private String photoUrl;
	
	private boolean accountHasSubscription;
	
	private String profileId;
	
	private Account account;
	
	private List<Subscription> subscriptions;

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	
}
