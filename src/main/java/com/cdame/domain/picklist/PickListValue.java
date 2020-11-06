package com.cdame.domain.picklist;

public class PickListValue {

	private String value;
	private String label;
	private boolean active;
	private boolean defaultValue;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(boolean defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	
	
}
