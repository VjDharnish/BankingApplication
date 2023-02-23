package com.dharun.bankingapp.user;

import java.util.List;

public interface UserViewCallBack {

	void getTransactionHistory();

	void invalidPin(String string);

	void showTransactionHistory(List<List<String>> transactionHistory);

	void getBalance();

	void showBalance(double balance);

	void showProfile(long accountNumber, String ifscode, String name, String address, long phoneNumber);

	void backToLogin();

	void exit();

	void setpin();

	void changePin();

	void userOptions();

	void forgotPin();

	void invalidOption();

	void setNewPin();

	void invalidPin();

	void pinMismatch();

	void pinAdded(String string);

	void pinNotMatch();

	void goTransaction();

}
