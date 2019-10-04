package com.nwpu.model;

public class BorrowBook {

	private String borrowID;
	private String studentID;
	private String borrowName;
	private int money;
	
	private Student student;

	public String getBorrowID() {
		return borrowID;
	}

	public void setBorrowID(String borrowID) {
		this.borrowID = borrowID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getBorrowName() {
		return borrowName;
	}

	public void setBorrowName(String borrowName) {
		this.borrowName = borrowName;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
