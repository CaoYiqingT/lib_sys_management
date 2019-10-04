package com.nwpu.model;

import java.util.Date;

public class DormApplication {

	private String applyNumber;
	private String studentID;
	private String applyKind;
	private String other;
	private String date;
	private boolean status;
	
	public String getApplyNumber() {
		return applyNumber;
	}
	
	public void setApplyNumber(String applyNumber) {
		this.applyNumber = applyNumber;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public String getApplyKind() {
		return applyKind;
	}
	
	public void setApplyKind(String applyKind) {
		this.applyKind = applyKind;
	}
	
	public String getOther() {
		return other;
	}
	
	public void setOther(String other) {
		this.other = other;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
