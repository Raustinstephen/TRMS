package com.revature.beans;

public class ReimView {
	private int rid;
	private String status;
	private String eventName;
	private String eventType;
	private String dateSubmitted;
	private double cost;
	private double reimb;
	private String grade;
	private String feedback;
	
	



	public ReimView() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReimView(int rid, int status, String eventName, int eventType, String dateSubmitted, double cost,
			double reimb, String grade, String feedback) {
		super();
		this.rid = rid;
		if(status == 0) {
			this.status = "Under Review-Direct Supervisor";
		}else if(status == 1) {
			this.status = "Under Review-Department Head";
		}else if(status == 2) {
			this.status = "Under Review-Ben. Coordinator";
		}else if(status == 3) {
			this.status = "Approved";
		}else if(status == 4) {
			this.status = "Denied by Direct Supervisor";
		}else if(status == 5) {
			this.status = "Denied by Department Head";
		}else if(status == 6){
			this.status = "Denied by Benefits Coordinator";
		}else if(status == 7) {
			this.status = "Withdrawn";
		}else {
			this.status = "error";
		}
		this.eventName = eventName;
		if(eventType == 1) {
			this.eventType = "University Course";
		}else if(eventType == 2) {
			this.eventType = "Seminar";
		}else if(eventType == 3) {
			this.eventType = "Certification Prep";
		}else if(eventType == 4) {
			this.eventType = "Certification";
		}else if(eventType == 5) {
			this.eventType = "Technical Training";
		}else if(eventType == 6) {
			this.eventType = "Other";
		}else {
			this.eventType = "error";
		}
		this.dateSubmitted = dateSubmitted;
		this.cost = cost;
		this.reimb = reimb;
		this.grade = grade;
		this.feedback = feedback;
	}


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(int status) {
		if(status == 0) {
			this.status = "Under Review-Direct Supervisor";
		}else if(status == 1) {
			this.status = "Under Review-Department Head";
		}else if(status == 2) {
			this.status = "Under Review-Ben. Coordinator";
		}else if(status == 3) {
			this.status = "Approved";
		}else if(status == 4) {
			this.status = "Denied by Direct Supervisor";
		}else if(status == 5) {
			this.status = "Denied by Department Head";
		}else if(status == 6){
			this.status = "Denied by Benefits Coordinator";
		}else if(status == 7) {
			this.status = "Withdrawn";
		}else {
			this.status = "error";
		}
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


	public void setEventType(int eventType) {
		if(eventType == 1) {
			this.eventType = "University Course";
		}else if(eventType == 2) {
			this.eventType = "Seminar";
		}else if(eventType == 3) {
			this.eventType = "Certification Prep";
		}else if(eventType == 4) {
			this.eventType = "Certification";
		}else if(eventType == 5) {
			this.eventType = "Technical Training";
		}else if(eventType == 6) {
			this.eventType = "Other";
		}else {
			this.eventType = "error";
		}
	}


	public String getDateSubmitted() {
		return dateSubmitted;
	}


	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public double getReimb() {
		return reimb;
	}


	public void setReimb(double reimb) {
		this.reimb = reimb;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	@Override
	public String toString() {
		return "reimbView [rid=" + rid + ", status=" + status + ", eventName=" + eventName + ", eventType=" + eventType
				+ ", dateSubmitted=" + dateSubmitted + ", cost=" + cost + ", reimb=" + reimb + ", grade=" + grade
				+ ", feedback=" + feedback + "]";
	}
}
