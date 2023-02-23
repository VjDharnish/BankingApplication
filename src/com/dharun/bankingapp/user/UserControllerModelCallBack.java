package com.dharun.bankingapp.user;

import com.dharun.bankingapp.dto.Customer;

public interface UserControllerModelCallBack {

	void showProfile(Customer myDetails);

	void showBalance(double balance);

	void pinAdded();

}
