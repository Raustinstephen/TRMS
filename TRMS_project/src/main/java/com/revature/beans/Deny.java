package com.revature.beans;

public class Deny {
	private String reason;
	private int rid;
	
	public Deny() {
		super();
	}

	public Deny(String reason, int rid) {
		super();
		this.reason = reason;
		this.rid = rid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Deny [reason=" + reason + ", rid=" + rid + "]";
	}
	
	
	
}
