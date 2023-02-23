package com.dharun.bankingapp.user;

import java.util.List;

import com.dharun.bankingapp.dto.Customer;
import com.dharun.bankingapp.dto.Transaction;

public interface UserModelCallBack {

	void viewProfile(String username);

	List<Transaction> getTransactionHistory(String username);

	int IsValidPin(String username);

	void getBalance(String username);

	void addPin(int newPin, String username);



}
