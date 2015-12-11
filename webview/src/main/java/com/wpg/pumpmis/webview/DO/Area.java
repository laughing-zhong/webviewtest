package com.wpg.pumpmis.webview.DO;

public class Area {
	public Area(){}
	private String Value;
	private String Name;
	private String CodeCategory;
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
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	private String OrderId;

}
