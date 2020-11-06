package com.cdame.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("user_id")
	private Long userId;
	private String uid;
	@JsonProperty("user_name")
	private String mail;
	private Contact contact;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
