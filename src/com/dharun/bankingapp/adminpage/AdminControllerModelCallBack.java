package com.dharun.bankingapp.adminpage;

import com.dharun.bankingapp.dto.Customer;

public interface AdminControllerModelCallBack {


	void showAccount(Customer getAccount);

	void noAccount(String string);

	void removedSuccessFull(String string);

	void invalidBranch(String string);

	void showAccountToRemove(Customer getAccount);

	

}
