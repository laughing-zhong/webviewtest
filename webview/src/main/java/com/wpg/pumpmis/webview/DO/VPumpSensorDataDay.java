package com.wpg.pumpmis.webview.DO;

public class VPumpSensorDataDay {
	/**
	 * <DateTime>2015-04-20T00:00:00</DateTime>
<ProjectName>14080000</ProjectName>
<TagName>InletPressure</TagName>
<Pv>238336.6510</Pv>
<Min>195183</Min>
<Max>281535</Max>
<Count>85777</Count>
	 */
	
	
	private String DateTime;
	public String getDateTime() {
		return DateTime;
	}
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getTagName() {
		return TagName;
	}
	public void setTagName(String tagName) {
		TagName = tagName;
	}
	public String getPv() {
		return Pv;
	}
	public void setPv(String pv) {
		Pv = pv;
	}
	public String getMin() {
		return Min;
	}
	public void setMin(String min) {
		Min = min;
	}
	public String getMax() {
		return Max;
	}
	public void setMax(String max) {
		Max = max;
	}
	public String getCount() {
		return Count;
	}
	public void setCount(String count) {
		Count = count;
	}
	private String ProjectName;
	private String TagName;
	private String Pv;
	private String  Min;
	private String  Max;
	private String  Count;

}
