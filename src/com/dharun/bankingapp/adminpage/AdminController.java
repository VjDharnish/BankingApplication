package com.dharun.bankingapp.adminpage;

import com.dharun.bankingapp.dto.Customer;
import java.util.regex.*;
public class AdminController implements AdminControllerViewCallBack,AdminControllerModelCallBack {
	private AdminViewCallBack adminView;
	private AdminModelCallBack adminModel;
	AdminController(AdminViewCallBack adminView){
		this.adminModel = new AdminModel(this);
		this.adminView = adminView;
	}
	@Override
	public boolean verifyAdmin(String username, String password) {
		if(adminModel.verifyAdmin(username,password)) {
			return true;
		}
		return false;
		
	}
	@Override
	public void adminOptions(int option) {
		switch(option) {
		case '1':
			adminView.addAccount();
			break;
		case '2':
			adminView.removeAccount();
			break;
		case '3':
			adminView.getAccount();
			break;
		case '4':
			adminView.goBack();
			break;
		default:
			adminView.invalidOption();
				break;
		}
		
	}
	
	@Override
	public void addAccount(String firstName, String lastName, String address, long phoneNumber,
			double initialDeposit, String username, String password) {

		 Customer newCustomer = adminModel.addAccount(firstName,lastName,address,phoneNumber,initialDeposit,username,password);
		 if(newCustomer == null) {
			 adminView.addedFailed("Customer Already Present");
		 }
		 else {
			 adminView.addedSuccess(newCustomer.getAccountNumber(),newCustomer.getIfscode(),newCustomer.getName(),newCustomer.getAddress(),newCustomer.getPhoneNumber(),newCustomer.getBalance());
		 }
			 
	}
	@Override
	public void getAccount(long accountNo) {
		// TODO Auto-generated method stub
		adminModel.getAccount(accountNo);
		
	}
	@Override
	public void showAccount(Customer getAccount) {
		
		adminView.showAccount(getAccount.getAccountNumber(),getAccount.getIfscode(),getAccount.getName(),getAccount.getAddress(),getAccount.getPhoneNumber(),getAccount.getBalance());
	}
	@Override
	public void noAccount(String errorMessage) {
		// TODO Auto-generated method stub
		adminView.noAccount(errorMessage);
		
	}
	@Override
	public void confirmRemove(long confirm) {
		adminModel.confirmRemove(confirm);
		
	}
	@Override
	public void removedSuccessFull(String success) {
		adminView.removeSuccess(success);
		
	}
	public boolean validatePhone(long phone) {
		Pattern pattern = Pattern.compile("[6-9][0-9]{9}");
		String num = Long.toString(phone);
		Matcher match = pattern.matcher(num);
		if(match.find() && num.length()==10) {
			return true;
		}
		return false;
	}
	@Override
	public void invalidBranch(String string) {
		// TODO Auto-generated method stub
		adminView.invalidBranch(string);
		
	}
	@Override
	public void getAccountToRemove(long accountNo) {
		// TODO Auto-generated method stub
		adminModel.getAccountToRemove(accountNo);
		
		
	}
	@Override
	public void showAccountToRemove(Customer getAccount) {
		// TODO Auto-generated method stub
		adminView.showAccountToRemove(getAccount.getAccountNumber(),getAccount.getIfscode(),getAccount.getUsername(),getAccount.getAddress(),getAccount.getPhoneNumber(),getAccount.getBalance());
		
	}

}
