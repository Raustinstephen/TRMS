package com.revature.beans;

public class ReimburstReq {
	private String eventName;
	private String address;
	private String city;
	private String state;
	private String eventDesc;
	private String justification;
	private String eventCost;
	private String gradeFormat;
	private String eventType;
	private String hoursMissed;
	
	
	
	public ReimburstReq() {
		super();
	}
	
	public ReimburstReq(String eventName, String address, String city, String state, String eventDesc,
			String justification, String eventCost, String gradeFormat, String eventType, String hoursMissed) {
		super();
		this.eventName = eventName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.eventDesc = eventDesc;
		this.justification = justification;
		this.eventCost = eventCost;
		this.gradeFormat = gradeFormat;
		this.eventType = eventType;
		this.hoursMissed = hoursMissed;
	}

	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public String getEventCost() {
		return eventCost;
	}
	public void setEventCost(String eventCost) {
		this.eventCost = eventCost;
	}
	public String getGradeFormat() {
		return gradeFormat;
	}
	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public String getHoursMissed() {
		return hoursMissed;
	}
	public void setHoursMissed(String hoursMissed) {
		this.hoursMissed = hoursMissed;
	}
	@Override
	public String toString() {
		return "ReimburstReq [eventName=" + eventName + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", eventDesc=" + eventDesc + ", justification=" + justification + ", eventCost=" + eventCost
				+ ", gradeFormat=" + gradeFormat + ", eventType=" + eventType + ", hoursMissed=" + hoursMissed + "]";
	}
	

	
	
}
