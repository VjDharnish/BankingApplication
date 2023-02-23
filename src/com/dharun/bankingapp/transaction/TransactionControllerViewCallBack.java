package com.dharun.bankingapp.transaction;

public interface TransactionControllerViewCallBack {

	void verifyReceipant(int accNum, int confirmAcc, String ifsCode);

	void transOption(char option, String receipantName, String receipantBranch);

	void payAmount(String username, int amount, int pin, String receiver, String branch);

}
