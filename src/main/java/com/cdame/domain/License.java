package com.cdame.domain;

import java.util.Date;

public class License {
	
	private String id;
	private String name;
	private String type;
	private String version;
	private Long cpuCores;
	private Date startDate;
	private Date endDate;
	private Long instances;
	private String hostname;
	private String contactId;
	private String assignee;
	private String assigneeMail;
	private String notifyEmail;
	private String requestKey;
	private String edition;
	private String status;
	private Boolean active;
	private String licenseeCompany;
	private Date deliveryDateTime;
	private String subscriptionId;
	private String disableChecks;
	
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Long getCpuCores() {
		return cpuCores;
	}
	public void setCpuCores(Long cpuCores) {
		this.cpuCores = cpuCores;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getInstances() {
		return instances;
	}
	public void setInstances(Long instances) {
		this.instances = instances;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getAssigneeMail() {
		return assigneeMail;
	}
	public void setAssigneeMail(String assigneeMail) {
		this.assigneeMail = assigneeMail;
	}
	public String getRequestKey() {
		return requestKey;
	}
	public void setRequestKey(String requestKey) {
		this.requestKey = requestKey;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getDeliveryDateTime() {
		return deliveryDateTime;
	}
	public void setDeliveryDateTime(Date deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getNotifyEmail() {
		return notifyEmail;
	}
	public void setNotifyEmail(String notifyEmail) {
		this.notifyEmail = notifyEmail;
	}
	public String getLicenseeCompany() {
		return licenseeCompany;
	}
	public void setLicenseeCompany(String licenseeCompany) {
		this.licenseeCompany = licenseeCompany;
	}
	public String getDisableChecks() {
		return disableChecks;
	}
	public void setDisableChecks(String disableChecks) {
		this.disableChecks = disableChecks;
	}
	
}
