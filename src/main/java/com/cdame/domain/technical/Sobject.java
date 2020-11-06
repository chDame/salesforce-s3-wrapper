package com.cdame.domain.technical;

import java.util.Map;

public class Sobject {

	private String name;
	private String label;
	private boolean custom;
	private boolean creatable;
	private boolean deletable;
	private boolean updateable;
	private boolean queryable;
	private String keyPrefix;
	private Map<String, String> urls;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isCustom() {
		return custom;
	}
	public void setCustom(boolean custom) {
		this.custom = custom;
	}
	public boolean isCreatable() {
		return creatable;
	}
	public void setCreatable(boolean creatable) {
		this.creatable = creatable;
	}
	public boolean isDeletable() {
		return deletable;
	}
	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}
	public boolean isUpdateable() {
		return updateable;
	}
	public void setUpdateable(boolean updateable) {
		this.updateable = updateable;
	}
	public boolean isQueryable() {
		return queryable;
	}
	public void setQueryable(boolean queryable) {
		this.queryable = queryable;
	}
	public String getKeyPrefix() {
		return keyPrefix;
	}
	public void setKeyPrefix(String keyPrefix) {
		this.keyPrefix = keyPrefix;
	}
	public Map<String, String> getUrls() {
		return urls;
	}
	public void setUrls(Map<String, String> urls) {
		this.urls = urls;
	}
	
	
	
}
