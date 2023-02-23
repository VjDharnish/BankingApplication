package com.dharun.bankingapp.user;

import com.dharun.bankingapp.dto.*;
import com.dharun.bankingapp.repository.YourBankRepo;
import java.util.List;
public class UserModel implements UserModelCallBack{
	private UserControllerModelCallBack userController;
	public UserModel(UserControllerModelCallBack userController) {
		this.userController= userController;
	}
	@Override
	public void viewProfile(String username) {
		// TODO Auto-generated method stub
		Customer myDetails = YourBankRepo.getInstance().myProfile(username);
		userController.showProfile(myDetails);
		
	}
	@Override
	public List<Transaction> getTransactionHistory(String username) {
		List<Transaction> transactionHistory = YourBankRepo.getInstance().getTransactionHistory(username);
		return transactionHistory;
	}
	@Override
	public int IsValidPin(String username) {
		int validPin = YourBankRepo.getInstance().getPin(username);
		return validPin;
	}
	@Override
	public void getBalance(String username) {
		double balance = YourBankRepo.getInstance().getBalance(username);
		userController.showBalance(balance);
	}
	@Override
	public void addPin(int newPin,String username) {
		if(YourBankRepo.getInstance().setPin(newPin,username)) {
			userController.pinAdded();
		}
		
	}

}
