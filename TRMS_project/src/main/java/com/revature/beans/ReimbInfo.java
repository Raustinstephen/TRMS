package com.revature.beans;

public class ReimbInfo {
	private String eventName;
	private String eventType;
	private String eventDesc;
	private String location;
	private String eventTime;
	private double eventCost;
	private String gradeFormat;
	private String justification;
	private int reimbStatus;
	private double hoursMissed;
	private String nextAuthorize;
	private String timeStamp;
	private String firstName;
	private String lastName;
	private String email;
	private String reportsTo;
	private String totalAwarded;
	
	public ReimbInfo(String eventName, String eventType, String eventDesc, String location, String eventTime,
			double eventCost2, String gradeFormat, String justification, int reimbStatus2, double hoursMissed2,
			String nextAuthorize, String timeStamp, String firstName, String lastName, String email, String reportsTo,
			String totalAwarded) {
		super();
		this.eventName = eventName;
		this.eventType = eventType;
		this.eventDesc = eventDesc;
		this.location = location;
		this.eventTime = eventTime;
		this.eventCost = eventCost2;
		this.gradeFormat = gradeFormat;
		this.justification = justification;
		this.reimbStatus = reimbStatus;
		this.hoursMissed = hoursMissed;
		this.nextAuthorize = nextAuthorize;
		this.timeStamp = timeStamp;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.reportsTo = reportsTo;
		this.totalAwarded = totalAwarded;
	}
	
	
	
	public ReimbInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
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
	public String getEventDesc() {
		return eventDesc;
	}
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public double getEventCost() {
		return eventCost;
	}
	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}
	public String getGradeFormat() {
		return gradeFormat;
	}
	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public int getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(int reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public double getHoursMissed() {
		return hoursMissed;
	}
	public void setHoursMissed(double hoursMissed) {
		this.hoursMissed = hoursMissed;
	}
	public String getNextAuthorize() {
		return nextAuthorize;
	}
	public void setNextAuthorize(String nextAuthorize) {
		this.nextAuthorize = nextAuthorize;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}
	public String getTotalAwarded() {
		return totalAwarded;
	}
	public void setTotalAwarded(String totalAwarded) {
		this.totalAwarded = totalAwarded;
	}



	@Override
	public String toString() {
		return "ReimbInfo [eventName=" + eventName + ", eventType=" + eventType + ", eventDesc=" + eventDesc
				+ ", location=" + location + ", eventTime=" + eventTime + ", eventCost=" + eventCost + ", gradeFormat="
				+ gradeFormat + ", justification=" + justification + ", reimbStatus=" + reimbStatus + ", hoursMissed="
				+ hoursMissed + ", nextAuthorize=" + nextAuthorize + ", timeStamp=" + timeStamp + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", reportsTo=" + reportsTo
				+ ", totalAwarded=" + totalAwarded + "]";
	}

	
	
}
