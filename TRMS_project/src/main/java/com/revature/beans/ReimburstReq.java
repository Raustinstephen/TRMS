package com.revature.beans;

public class ReimburstReq {
	private String eventName;
	private String eventType;
	private String gradeFormat;
	private String date;
	private String address;
	private String city;
	private String state;
	private String eventCost;
	private String hoursMissed;
	private String eventJust;
	
	
	public ReimburstReq() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReimburstReq(String eventName, String eventType, String gradeFormat, String date, String address,
			String city, String state, String eventCost, String hoursMissed, String eventJust) {
		super();
		this.eventName = eventName;
		this.eventType = eventType;
		this.gradeFormat = gradeFormat;
		this.date = date;
		this.address = address;
		this.city = city;
		this.state = state;
		this.eventCost = eventCost;
		this.hoursMissed = hoursMissed;
		this.eventJust = eventJust;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getEventType() {
		return eventType;
	}


	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	public String getGradeFormat() {
		return gradeFormat;
	}


	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
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


	public String getEventCost() {
		return eventCost;
	}


	public void setEventCost(String eventCost) {
		this.eventCost = eventCost;
	}


	public String getHoursMissed() {
		return hoursMissed;
	}


	public void setHoursMissed(String hoursMissed) {
		this.hoursMissed = hoursMissed;
	}


	public String getEventJust() {
		return eventJust;
	}


	public void setEventJust(String eventJust) {
		this.eventJust = eventJust;
	}


	@Override
	public String toString() {
		return "ReimburstReq [eventName=" + eventName + ", eventType=" + eventType + ", gradeFormat=" + gradeFormat
				+ ", date=" + date + ", address=" + address + ", city=" + city + ", state=" + state + ", eventCost="
				+ eventCost + ", hoursMissed=" + hoursMissed + ", eventJust=" + eventJust + "]";
	}
}
