package com.nwpu.model;

public class Dorm {

	private String dormNumber;
	private int dormKind;
	private int dormPrice;
	private boolean isFull;
	private String sex;
	
	public String getDormNumber() {
		return dormNumber;
	}
	
	public void setDormNumber(String dormNumber) {
		this.dormNumber = dormNumber;
	}
	
	public int getDormKind() {
		return dormKind;
	}
	
	public void setDormKind(int dormKind) {
		this.dormKind = dormKind;
	}
	
	public int getDormPrice() {
		return dormPrice;
	}
	
	public void setDormPrice(int dormPrice) {
		this.dormPrice = dormPrice;
	}

	
	@Override
	public String toString() {
		return "Dorm [dormNumber=" + dormNumber + ", dormKind=" + dormKind + ", dormPrice=" + dormPrice + "]";
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
