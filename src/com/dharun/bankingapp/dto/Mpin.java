package com.dharun.bankingapp.dto;

public class Mpin  {
	private String username;
	private int mpin;
	public Mpin(String username,int mpin){
		this.username=username;
		this.mpin = mpin;
	}
	public int getMpin() {
		return mpin;
	}
	public void setMpin(int mpin) {
		this.mpin = mpin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
