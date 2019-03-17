package com.revature.beans;

public class ReimbInfo {
	
	private int rid;
	private String dateSubmitted;
	private String empName;
	private String empTitle;
	private String empDept;
	private String eventName;
	private String eventType;
	private String gradeFormat;
	private String location;
	private String date;
	private String grade;
	private double cost;
	private double estReimb;
	private double hrsMissed;
	private String justification;
	
	
	
	
	public ReimbInfo() {
		super();
	}




	public ReimbInfo(int rid, String dateSubmitted, String empName, String empTitle, int empDept, String eventName,
			int eventType, int gradeFormat, String location, String date, String grade, double cost,
			double estReimb, double hrsMissed, String justification) {
		super();
		this.rid = rid;
		this.dateSubmitted = dateSubmitted;
		this.empName = empName;
		this.empTitle = empTitle;
		if(empDept == 100)this.empDept = "Clerical";
		else if(empDept == 200)this.empDept = "IT";
		else if(empDept == 300)this.empDept = "Accounting";
		else if(empDept == 400)this.empDept = "HR";
		else if(empDept == 500)this.empDept = "General";
		else if(empDept == 600)this.empDept = "Executive";
		else this.empDept = "error";
		this.eventName = eventName;
		if(eventType == 1)this.eventType = "University Course";
		else if(eventType == 2)this.eventType = "Seminar";
		else if(eventType == 3)this.eventType = "Certification Prep";
		else if(eventType == 4)this.eventType = "Certification";
		else if(eventType == 5)this.eventType = "Technical Training";
		else if(eventType == 6)this.eventType = "Other";
		else this.eventType = "error";
		if(gradeFormat == 1)this.gradeFormat = "A - F";
		else if(gradeFormat == 2)this.gradeFormat = "Pass/Fail";
		else if(gradeFormat == 3)this.gradeFormat = "Percentage";
		else if(gradeFormat == 4)this.gradeFormat = "Score";
		else if(gradeFormat == 5)this.gradeFormat = "Does not apply";
		else this.gradeFormat = "error";
		this.location = location;
		this.date = date;
		this.grade = grade;
		this.cost = cost;
		this.estReimb = estReimb;
		this.hrsMissed = hrsMissed;
		this.justification = justification;
	}




	public double getHrsMissed() {
		return hrsMissed;
	}




	public void setHrsMissed(double hrsMissed) {
		this.hrsMissed = hrsMissed;
	}




	public int getRid() {
		return rid;
	}




	public void setRid(int rid) {
		this.rid = rid;
	}




	public String getDateSubmitted() {
		return dateSubmitted;
	}




	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}




	public String getEmpName() {
		return empName;
	}




	public void setEmpName(String empName) {
		this.empName = empName;
	}




	public String getEmpTitle() {
		return empTitle;
	}




	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}




	public String getEmpDept() {
		return empDept;
	}




	public void setEmpDept(int empDept) {
		if(empDept == 100)this.empDept = "Clerical";
		else if(empDept == 200)this.empDept = "IT";
		else if(empDept == 300)this.empDept = "Accounting";
		else if(empDept == 400)this.empDept = "HR";
		else if(empDept == 500)this.empDept = "General";
		else if(empDept == 600)this.empDept = "Executive";
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
		if(eventType == 1)this.eventType = "University Course";
		else if(eventType == 2)this.eventType = "Seminar";
		else if(eventType == 3)this.eventType = "Certification Prep";
		else if(eventType == 4)this.eventType = "Certification";
		else if(eventType == 5)this.eventType = "Technical Training";
		else if(eventType == 6)this.eventType = "Other";
		else this.eventType = "error";
	}




	public String getGradeFormat() {
		return gradeFormat;
	}




	public void setGradeFormat(int gradeFormat) {
		if(gradeFormat == 1)this.gradeFormat = "A - F";
		else if(gradeFormat == 2)this.gradeFormat = "Pass/Fail";
		else if(gradeFormat == 3)this.gradeFormat = "Percentage";
		else if(gradeFormat == 4)this.gradeFormat = "Score";
		else if(gradeFormat == 5)this.gradeFormat = "Does not apply";
		else this.gradeFormat = "error";
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public String getDate() {
		return date;
	}




	public void setDate(String date) {
		this.date = date;
	}




	public String getGrade() {
		return grade;
	}




	public void setGrade(String grade) {
		this.grade = grade;
	}




	public double getCost() {
		return cost;
	}




	public void setCost(double cost) {
		this.cost = cost;
	}




	public double getEstReimb() {
		return estReimb;
	}




	public void setEstReimb(double estReimb) {
		this.estReimb = estReimb;
	}




	public String getJustification() {
		return justification;
	}




	public void setJustification(String justification) {
		this.justification = justification;
	}




	@Override
	public String toString() {
		return "ReimbInfo [rid=" + rid + ", dateSubmitted=" + dateSubmitted + ", empName=" + empName + ", empTitle="
				+ empTitle + ", empDept=" + empDept + ", eventName=" + eventName + ", eventType=" + eventType
				+ ", gradeFormat=" + gradeFormat + ", location=" + location + ", date=" + date + ", grade=" + grade
				+ ", cost=" + cost + ", estReimb=" + estReimb + ", justification=" + justification + "]";
	}


	
	
}
