package com.dharun.bankingapp.dto;

import java.util.LinkedList;
import java.util.List;

public class Customer extends Person{
	private long accountNumber;
	protected String username;
	private double balance;
	private String ifscode;

	private List<Transaction> transactions = new LinkedList<>();
	public Customer(long accountNumber,String ifscode,String firstName, String lastName, String address, long phoneNumber,double initialDeposit,String username) {
		super(firstName, lastName, address, phoneNumber);
		this.accountNumber= accountNumber;
		this.ifscode= ifscode;
		this.username = username;
		this.balance = balance+initialDeposit;		
	}

	public Customer(String username2) {
		this.username = username2;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscode() {
		return ifscode;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void addTransaction(Transaction transaction) {
		transactions.add(0,transaction);
	}
	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", username=" + username 
				+ ", balance=" + balance + ", ifscode=" + ifscode + ", transactions=" + transactions + "]";
	}
	
}