package com.dharun.bankingapp.adminpage;

public interface AdminControllerViewCallBack {

	boolean verifyAdmin(String username, String password);

	void adminOptions(int option);

	void addAccount(String firstName, String lastName, String address, long phoneNumber, double initialDeposit,
			String username, String password);

	void getAccount(long accountNo);

	void confirmRemove(long confirm);

	boolean validatePhone(long phone);

	void getAccountToRemove(long accountNo);

}
