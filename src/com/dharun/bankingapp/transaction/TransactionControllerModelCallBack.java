package com.dharun.bankingapp.transaction;

import com.dharun.bankingapp.dto.Customer;

public interface TransactionControllerModelCallBack {

	void invalidAccount(String invalidMessage);

	void showReceipant(Customer receipant);

	void paymentSuccess();

}
