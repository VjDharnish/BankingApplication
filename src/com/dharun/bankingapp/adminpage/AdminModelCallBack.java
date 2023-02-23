package com.dharun.bankingapp.adminpage;

import com.dharun.bankingapp.dto.Customer;

public interface AdminModelCallBack {

	boolean verifyAdmin(String username, String password);
	
	Customer addAccount(String firstName, String lastName, String address, long phoneNumber, double initialDeposit,
			String username, String password);

	void getAccount(long accountNo);

	void confirmRemove(long confirm);

	void getAccountToRemove(long accountNo);

}
