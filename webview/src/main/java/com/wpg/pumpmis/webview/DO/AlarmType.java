package com.wpg.pumpmis.webview.DO;

public class AlarmType {
	
	private String Value;
	private String Name;
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCodeCategory() {
		return CodeCategory;
	}
	public void setCodeCategory(String codeCategory) {
		CodeCategory = codeCategory;
	}
	public String getExtendValue() {
		return ExtendValue;
	}
	public void setExtendValue(String extendValue) {
		ExtendValue = extendValue;
	}
	private String CodeCategory;
	private String ExtendValue;

}
