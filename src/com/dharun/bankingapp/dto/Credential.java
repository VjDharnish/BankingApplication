package com.dharun.bankingapp.dto;

public class Credential extends Customer{
	private String password;
	public Credential(long accountNumber,String ifscode,String firstName, String lastName, String address, long phoneNumber,double initialDeposit,String username,String password){
		super( accountNumber,ifscode,firstName, lastName, address,phoneNumber,initialDeposit,username);
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
