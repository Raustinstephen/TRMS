package com.revature.beans;

public class Grade {
	private int reimbID;
	private String grade;
	
	
	public Grade() {
		super();
	}
	public Grade(int reimbID, String grade) {
		super();
		this.reimbID = reimbID;
		this.grade = grade;
	}
	public int getReimbID() {
		return reimbID;
	}
	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Grade [reimbID=" + reimbID + ", grade=" + grade + "]";
	}
	
	
}
