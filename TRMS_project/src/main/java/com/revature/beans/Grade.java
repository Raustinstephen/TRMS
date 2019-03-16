package com.revature.beans;

public class Grade {
	private int rid;
	private String grade;
	
	
	public Grade() {
		super();
	}


	public Grade(int rid, String grade) {
		super();
		this.rid = rid;
		this.grade = grade;
	}


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}

	
	
}
