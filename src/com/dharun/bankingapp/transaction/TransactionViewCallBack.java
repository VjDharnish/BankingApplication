package com.dharun.bankingapp.transaction;


public interface TransactionViewCallBack {

	void mismatch(String invalidMessage);

	void invalidAccount(String invalidMessage);

	void showReceipant(String receipantName, String receipantBranch, String string);

	void pay(String receiver, String branch);

	void cancel();

	void invalidAmount(String errorMessage);

	void paymentSuccess();

}
