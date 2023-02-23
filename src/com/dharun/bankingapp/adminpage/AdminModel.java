package com.dharun.bankingapp.adminpage;

import com.dharun.bankingapp.dto.*;
import com.dharun.bankingapp.repository.YourBankRepo;

public class AdminModel implements AdminModelCallBack {
	private AdminControllerModelCallBack adminController;
	private long accountNumber = 10000;

	public AdminModel(AdminControllerModelCallBack adminController) {
		this.adminController = adminController;
	}

	@Override
	public boolean verifyAdmin(String username, String password) {
		if (YourBankRepo.getInstance().verifyAdmin(username, password)) {
			return true;
		}
		return false;

	}

	@Override
	public Customer addAccount(String firstName, String lastName, String address, long phoneNumber,
			double initialDeposit, String username, String password) {
		String ifscode = Branch.setIfscode(address);
		if(ifscode == null) {
			adminController.invalidBranch("No Branch Available for this Location");
		}
		Customer newCustomer = YourBankRepo.getInstance().addAccount(accountNumber += 1, ifscode,firstName, lastName, address,
				phoneNumber, initialDeposit, username, password);
		return newCustomer;
	}

	@Override
	public void getAccount(long accountNo) {
		// TODO Auto-generated method stub
		Customer getAccount = YourBankRepo.getInstance().showAccount(accountNo);
		if(getAccount !=null)
		adminController.showAccount(getAccount);
		else {
			adminController.noAccount("No Account Present");
		}
		
	}

	@Override
	public void confirmRemove(long confirm) {
		if(YourBankRepo.getInstance().removeAccount(confirm)) {
			adminController.removedSuccessFull("Account Removed Successfully");
		}
		
	}

	@Override
	public void getAccountToRemove(long accountNo) {
		Customer getAccount = YourBankRepo.getInstance().showAccount(accountNo);
		if(getAccount !=null)
			adminController.showAccountToRemove(getAccount);
			else {
				adminController.noAccount("No Account Present");
			}
	}

}
