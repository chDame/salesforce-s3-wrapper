package com.cdame.domain.technical;

import com.cdame.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SsoUserEnveloppe {

	private String sessid;
	@JsonProperty("session_name")
	private String sessionName;
	private User user;
	public String getSessid() {
		return sessid;
	}
	public void setSessid(String sessid) {
		this.sessid = sessid;
	}
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
