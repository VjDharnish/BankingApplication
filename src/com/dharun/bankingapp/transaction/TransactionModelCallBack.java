package com.dharun.bankingapp.transaction;

public interface TransactionModelCallBack {

	void verifyReceipant(int accNum, String ifsCode);

	boolean isValidPin(String username, int pin);

	void payAmount(String username, int amount, String receiver, String branch);

}
