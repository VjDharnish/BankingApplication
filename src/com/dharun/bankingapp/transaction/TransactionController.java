package com.dharun.bankingapp.transaction;

import com.dharun.bankingapp.dto.Customer;

public class TransactionController implements TransactionControllerViewCallBack,TransactionControllerModelCallBack {
	private TransactionViewCallBack transactionView;
	private TransactionModelCallBack transactionModel;
	public TransactionController(TransactionViewCallBack transactionView) {
		this.transactionView= transactionView;
		this.transactionModel = new TransactionModel(this);
	}
	@Override
	public void verifyReceipant(int accNum, int confirmAcc, String ifsCode) {
		if(accNum == confirmAcc) {

			transactionModel.verifyReceipant(accNum,ifsCode);
		}
		else {
			transactionView.mismatch("Account Number Mismatch");
		}
		
	}
	@Override
	public void invalidAccount(String invalidMessage) {
		transactionView.invalidAccount(invalidMessage);
		
		
	}
	@Override
	public void showReceipant(Customer receipant) {
		String receipantName = receipant.getName();
		String receipantBranch = receipant.getAddress();

		transactionView.showReceipant(receipantName,receipantBranch,receipant.getUsername());
		
	}
	@Override
	public void transOption(char option,String receiver,String branch) {
		switch(option) {
		case '1':
		transactionView.pay( receiver,branch);
		break;
		case '2':
			transactionView.cancel();
		}
	}
	@Override
	public void payAmount(String username,int amount, int pin,String receiver,String branch) {
		if(amount <500 || amount>50000 )
			invalidAmount("Amount should between 500 and 50000");
		else {
			if(transactionModel.isValidPin(username,pin)) {
					transactionModel.payAmount(username,amount,receiver,branch);
			}
			else {
				invalidAmount("Incorrect PIN");
			}
		}
		
	}
	public void invalidAmount(String errorMessage) {
		transactionView.invalidAmount(errorMessage);
		
	}
	@Override
	public void paymentSuccess() {
		transactionView.paymentSuccess();
		
	}
	
	
}
