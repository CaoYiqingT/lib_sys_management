package com.nwpu.model;

import java.util.List;

public class Student {

	private String studentID;
	private String studentName;
	private String sex;
	private String identifyID;
	private String dormNumber;
	private boolean staySchool;
	private String projectKind;
	private boolean isAdmin;
	private String leaveDate;
	private String classID;
	private String QQemail;
	
	private Dorm dorm;
	private List<BorrowBook> borrowBook;
	
	public String getStudentID() {
		return studentID;
	}
	
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getIdentifyID() {
		return identifyID;
	}
	
	public void setIdentifyID(String identifyID) {
		this.identifyID = identifyID;
	}
	
	public boolean isStaySchool() {
		return staySchool;
	}
	
	public void setStaySchool(boolean staySchool) {
		this.staySchool = staySchool;
	}
	
	public String getProjectKind() {
		return projectKind;
	}
	
	public void setProjectKind(String projectKind) {
		this.projectKind = projectKind;
	}

	public Dorm getDorm() {
		return dorm;
	}

	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getDormNumber() {
		return dormNumber;
	}

	public void setDormNumber(String dormNumber) {
		this.dormNumber = dormNumber;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public List<BorrowBook> getBorrowBook() {
		return borrowBook;
	}

	public void setBorrowBook(List<BorrowBook> borrowBook) {
		this.borrowBook = borrowBook;
	}

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getQQemail() {
		return QQemail;
	}

	public void setQQemil(String qQemail) {
		QQemail = qQemail;
	}
	
	
}
