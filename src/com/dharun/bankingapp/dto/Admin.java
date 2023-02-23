package com.dharun.bankingapp.dto;

public class Admin extends Person{
	private String password;
	Admin(String firstName, String lastName, String address, long phoneNumber,String Password){
		super(firstName,lastName,address,phoneNumber);
		this.password=password;
	}
	public Admin(){
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
