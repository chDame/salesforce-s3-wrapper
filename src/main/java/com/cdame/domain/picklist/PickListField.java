package com.cdame.domain.picklist;

import java.util.List;

public class PickListField {

	private String name;
	
	private List<PickListValue> picklistValues;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PickListValue> getPicklistValues() {
		return picklistValues;
	}

	public void setPicklistValues(List<PickListValue> picklistValues) {
		this.picklistValues = picklistValues;
	}
	
	
	
}
