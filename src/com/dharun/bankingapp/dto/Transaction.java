package com.dharun.bankingapp.dto;
import java.time.LocalDate;
public class Transaction {
	private String username;
	private long transId;
	private String receipent;
	private LocalDate date;
	private String transAmount;
	public Transaction(String username, long transId, String receipent, LocalDate date, String transAmount) {
		super();
		this.username = username;
		this.transId = transId;
		this.receipent = receipent;
		this.date = date;
		this.transAmount = transAmount;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	public String getReceipent() {
		return receipent;
	}

	public void setReceipent(String receipent) {
		this.receipent = receipent;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}

	@Override
	public String toString() {
		return "Transaction [username=" + username + ", transId=" + transId + ", receipent=" + receipent + ", date="
				+ date + ", transAmount=" + transAmount + "]";
	}
	
	
	
	
}
