package com.nwpu.model;

public class Book {

	private String ISBN;
	private String bookName;
	private int number;
	private float bookPrice;
	private boolean auditing;
	private int requirment;
	private String providing;
	private String semeter;
	private double totalFine;
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public float getBookPrice() {
		return bookPrice;
	}
	
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	public boolean isAuditing() {
		return auditing;
	}
	
	public void setAuditing(boolean auditing) {
		this.auditing = auditing;
	}
	
	public int getRequirment() {
		return requirment;
	}
	
	public void setRequirment(int requirment) {
		this.requirment = requirment;
	}

	public String getProviding() {
		return providing;
	}

	public void setProviding(String providing) {
		this.providing = providing;
	}

	public String getSemeter() {
		return semeter;
	}

	public void setSemeter(String semeter) {
		this.semeter = semeter;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public double getTotalFine() {
		return totalFine;
	}

	public void setTotalFine(double totalFine) {
		this.totalFine = totalFine;
	}
	
	
}
