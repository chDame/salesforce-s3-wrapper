package com.cdame.domain;

import java.util.Date;
import java.util.List;

public class Subscription {

	private String id;

	private String name;

	private String edition;

	private String supportlevel;

	private boolean active;

	private Date startDate;

	private Date endDate;

	private Date productionDate;

	private boolean phoneCallback;

	private Long prodCoresTotal;

	private Long prodCoresUsed;

	private Long qualifCoresTotal;

	private Long qualifCoresUsed;

	private Long remainingDevelopmentLicenses;

	private Long remainingTrainingLicenses;

	private Long remainingProductionLicenses;

	private Long remainingPartnerLicenses;

	private Long remainingInternalLicenses;

	private Long remainingTrialLicenses;

	private Long remainingQualificationLicenses;

	private Long developmentCoresMax;

	private Long internalCoresMax;

	private Long trainingCoresMax;

	private Long partnerCoresMax;

	private Long trialCoresMax;

	private boolean authorizeDevelopmentLicenses;

	private boolean authorizeTrainingLicenses;

	private boolean authorizeProductionLicenses;

	private boolean authorizePartnerLicenses;

	private boolean authorizeInternalLicenses;

	private boolean authorizeTrialLicenses;

	private boolean authorizeQualificationLicenses;

	private boolean canGenerateBetaLicense;

	private List<Case> cases;

	private List<License> licenses;

	private String addOns;
	
	private String accountId;
	
	private Account account;
	
	private String slaTimezone;

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

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getSupportlevel() {
		return supportlevel;
	}

	public void setSupportlevel(String supportlevel) {
		this.supportlevel = supportlevel;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public boolean isPhoneCallback() {
		return phoneCallback;
	}

	public void setPhoneCallback(boolean phoneCallback) {
		this.phoneCallback = phoneCallback;
	}

	public Long getProdCoresTotal() {
		return prodCoresTotal;
	}

	public void setProdCoresTotal(Long prodCoresTotal) {
		this.prodCoresTotal = prodCoresTotal;
	}

	public Long getProdCoresUsed() {
		return prodCoresUsed;
	}

	public void setProdCoresUsed(Long prodCoresUsed) {
		this.prodCoresUsed = prodCoresUsed;
	}

	public Long getQualifCoresTotal() {
		return qualifCoresTotal;
	}

	public void setQualifCoresTotal(Long qualifCoresTotal) {
		this.qualifCoresTotal = qualifCoresTotal;
	}

	public Long getQualifCoresUsed() {
		return qualifCoresUsed;
	}

	public void setQualifCoresUsed(Long qualifCoresUsed) {
		this.qualifCoresUsed = qualifCoresUsed;
	}

	public Long getRemainingDevelopmentLicenses() {
		return remainingDevelopmentLicenses;
	}

	public void setRemainingDevelopmentLicenses(Long remainingDevelopmentLicenses) {
		this.remainingDevelopmentLicenses = remainingDevelopmentLicenses;
	}

	public Long getRemainingTrainingLicenses() {
		return remainingTrainingLicenses;
	}

	public void setRemainingTrainingLicenses(Long remainingTrainingLicenses) {
		this.remainingTrainingLicenses = remainingTrainingLicenses;
	}

	public Long getRemainingProductionLicenses() {
		return remainingProductionLicenses;
	}

	public void setRemainingProductionLicenses(Long remainingProductionLicenses) {
		this.remainingProductionLicenses = remainingProductionLicenses;
	}

	public Long getRemainingPartnerLicenses() {
		return remainingPartnerLicenses;
	}

	public void setRemainingPartnerLicenses(Long remainingPartnerLicenses) {
		this.remainingPartnerLicenses = remainingPartnerLicenses;
	}

	public Long getRemainingInternalLicenses() {
		return remainingInternalLicenses;
	}

	public void setRemainingInternalLicenses(Long remainingInternalLicenses) {
		this.remainingInternalLicenses = remainingInternalLicenses;
	}

	public Long getRemainingTrialLicenses() {
		return remainingTrialLicenses;
	}

	public void setRemainingTrialLicenses(Long remainingTrialLicenses) {
		this.remainingTrialLicenses = remainingTrialLicenses;
	}

	public Long getRemainingQualificationLicenses() {
		return remainingQualificationLicenses;
	}

	public void setRemainingQualificationLicenses(Long remainingQualificationLicenses) {
		this.remainingQualificationLicenses = remainingQualificationLicenses;
	}

	public Long getDevelopmentCoresMax() {
		return developmentCoresMax;
	}

	public void setDevelopmentCoresMax(Long developmentCoresMax) {
		this.developmentCoresMax = developmentCoresMax;
	}

	public Long getInternalCoresMax() {
		return internalCoresMax;
	}

	public void setInternalCoresMax(Long internalCoresMax) {
		this.internalCoresMax = internalCoresMax;
	}

	public Long getTrainingCoresMax() {
		return trainingCoresMax;
	}

	public void setTrainingCoresMax(Long trainingCoresMax) {
		this.trainingCoresMax = trainingCoresMax;
	}

	public Long getPartnerCoresMax() {
		return partnerCoresMax;
	}

	public void setPartnerCoresMax(Long partnerCoresMax) {
		this.partnerCoresMax = partnerCoresMax;
	}

	public Long getTrialCoresMax() {
		return trialCoresMax;
	}

	public void setTrialCoresMax(Long trialCoresMax) {
		this.trialCoresMax = trialCoresMax;
	}

	public boolean isAuthorizeDevelopmentLicenses() {
		return authorizeDevelopmentLicenses;
	}

	public void setAuthorizeDevelopmentLicenses(boolean authorizeDevelopmentLicenses) {
		this.authorizeDevelopmentLicenses = authorizeDevelopmentLicenses;
	}

	public boolean isAuthorizeTrainingLicenses() {
		return authorizeTrainingLicenses;
	}

	public void setAuthorizeTrainingLicenses(boolean authorizeTrainingLicenses) {
		this.authorizeTrainingLicenses = authorizeTrainingLicenses;
	}

	public boolean isAuthorizeProductionLicenses() {
		return authorizeProductionLicenses;
	}

	public void setAuthorizeProductionLicenses(boolean authorizeProductionLicenses) {
		this.authorizeProductionLicenses = authorizeProductionLicenses;
	}

	public boolean isAuthorizePartnerLicenses() {
		return authorizePartnerLicenses;
	}

	public void setAuthorizePartnerLicenses(boolean authorizePartnerLicenses) {
		this.authorizePartnerLicenses = authorizePartnerLicenses;
	}

	public boolean isAuthorizeInternalLicenses() {
		return authorizeInternalLicenses;
	}

	public void setAuthorizeInternalLicenses(boolean authorizeInternalLicenses) {
		this.authorizeInternalLicenses = authorizeInternalLicenses;
	}

	public boolean isAuthorizeTrialLicenses() {
		return authorizeTrialLicenses;
	}

	public void setAuthorizeTrialLicenses(boolean authorizeTrialLicenses) {
		this.authorizeTrialLicenses = authorizeTrialLicenses;
	}

	public boolean isAuthorizeQualificationLicenses() {
		return authorizeQualificationLicenses;
	}

	public void setAuthorizeQualificationLicenses(boolean authorizeQualificationLicenses) {
		this.authorizeQualificationLicenses = authorizeQualificationLicenses;
	}

	public boolean isCanGenerateBetaLicense() {
		return canGenerateBetaLicense;
	}

	public void setCanGenerateBetaLicense(boolean canGenerateBetaLicense) {
		this.canGenerateBetaLicense = canGenerateBetaLicense;
	}

	public List<Case> getCases() {
		return cases;
	}

	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

	public String getAddOns() {
		return addOns;
	}

	public void setAddOns(String addOns) {
		this.addOns = addOns;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<License> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<License> licenses) {
		this.licenses = licenses;
	}

	public String getSlaTimezone() {
		return slaTimezone;
	}

	public void setSlaTimezone(String slaTimezone) {
		this.slaTimezone = slaTimezone;
	}
}
