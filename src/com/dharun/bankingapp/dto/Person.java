package com.dharun.bankingapp.dto;

public class Person {
	protected String name;
	protected String address;
	protected long phoneNumber;
	public Person(String firstName, String lastName, String address, long phoneNumber) {
		super();
		this.name = firstName+" "+lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	Person(){
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
