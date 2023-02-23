package com.dharun.bankingapp.adminpage;

public interface AdminViewCallBack {

	void addAccount();

	void removeAccount();


	void addedFailed(String string);

	void addedSuccess(long accountNumber, String customerName, String location, String string, long phoneNumber, double balance);

	void goBack();

	void getAccount();

	void noAccount(String errorMessage);

	void removeSuccess(String success);

	void invalidBranch(String string);

	void showAccount(long accountNumber, String ifscode, String username, String address, long phoneNumber,
			double balance);

	void showAccountToRemove(long accountNumber, String ifscode, String username, String address, long phoneNumber,
			double balance);

	void invalidOption();
	

}
