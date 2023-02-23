package com.dharun.bankingapp.transaction;

import java.time.LocalDate;

import com.dharun.bankingapp.dto.Branch;
import com.dharun.bankingapp.dto.Customer;
import com.dharun.bankingapp.repository.YourBankRepo;

public class TransactionModel implements TransactionModelCallBack {
	private TransactionControllerModelCallBack transactionController;
	private static long transId=20000;
	public TransactionModel(TransactionControllerModelCallBack transactionController) {
		this.transactionController = transactionController;
	}

	@Override
	public void verifyReceipant(int accNum, String ifsCode) {

		String branch = Branch.getBranch(ifsCode);
		if(branch == null) {

			invalidAccount("Branch Not Found");
		}
		else {

		Customer receipant = YourBankRepo.getInstance().verifyReceipant(accNum,branch);
		if(receipant == null ) {
			invalidAccount("Invalid Receipant");
		}
		else { 

			transactionController.showReceipant(receipant);
		}
		}
	}
	private void invalidAccount(String invalidMessage) {
		transactionController.invalidAccount(invalidMessage);
	}

	@Override
	public boolean isValidPin(String username,int pin) {
		if(YourBankRepo.getInstance().isValidPin(username,pin)) {
			return true;
		}
		return false;
	}

	@Override
	public void payAmount(String username, int amount,String receiver,String branch) {
		Customer myAccount = YourBankRepo.getInstance().getAccount(username);
		double myBalance = myAccount.getBalance();
		if(myBalance< amount) {
		transactionController.invalidAccount("Insufficient Balance");
		}
		else {
			Customer receipantAccount = YourBankRepo.getInstance().getAccount(receiver);
			double receiverBalance =receipantAccount.getBalance();
			receiverBalance  +=amount;
			myBalance -=amount;
			String sentAmount = "-" +amount;
			String receivedAmount = "+" +amount;
			transId++;
			if(YourBankRepo.getInstance().updateMyTransact(myAccount,transId,receipantAccount,LocalDate.now(),sentAmount,receivedAmount,myBalance,receiverBalance))
			 {
				transactionController.paymentSuccess();
			}
		}
		
	}
	

}
