package com.dharun.bankingapp.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.dharun.bankingapp.dto.*;
import java.util.Random;

public class UserController implements UserControllerViewCallBack, UserControllerModelCallBack {
	private UserViewCallBack userView;
	private UserModelCallBack userModel;

	public UserController(UserViewCallBack userView) {
		this.userView = userView;
		this.userModel = new UserModel(this);

	}

	@Override
	public void userOptions(int option, String username) {
		// TODO Auto-generated method stub

		switch (option) {
		case 1:
			userView.goTransaction();
			break;
		case 2:
			userModel.viewProfile(username);
			break;
		case 3:
			userView.getTransactionHistory();
			break;
		case 4:
			userView.getBalance();
			break;
		case 5:
			userView.setpin();
			break;
		case 6:
			userView.backToLogin();
		case 0:
			userView.exit();

		}

	}

	@Override
	public void showProfile(Customer myDetails) {
		userView.showProfile(myDetails.getAccountNumber(), myDetails.getIfscode(), myDetails.getName(),
				myDetails.getAddress(), myDetails.getPhoneNumber());

	}

	@Override
	public boolean isValidPin(String username, int myPin) {
		if (myPin == userModel.IsValidPin(username)) {
		List<Transaction> history = userModel.getTransactionHistory(username);
 		showTransactionHistory(history);
			return true;
		} 
		else {
			userView.invalidPin("Invalid Pin");		
			return false;
		}

	}

	private void showTransactionHistory(List<Transaction> history) {
		List<List<String>> transactionHistory = new ArrayList<>();
		for (int i = 0; i<history.size(); i++) {
			Transaction transaction = history.get(i);
			List<String> details = new ArrayList<>();
			LocalDate localDate = transaction.getDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String formattedDate = localDate.format(formatter);
			String transId = Long.toString(transaction.getTransId());
			details.add(formattedDate);
			details.add(transId);
			details.add(transaction.getReceipent());
			details.add(transaction.getTransAmount());
		
			transactionHistory.add(new ArrayList<>(details));	

		}

		userView.showTransactionHistory(transactionHistory);
	}

	@Override
	public void getBalance(String username) {
		userModel.getBalance(username);

	}

	@Override
	public void showBalance(double balance) {
		userView.showBalance(balance);

	}

	@Override
	public void pinOptions(char option) {
		switch (option) {
		case '1':
			userView.changePin();
			break;
		case '2':
			userView.forgotPin();
			break;
		case '3':
			userView.userOptions();
			break;
		default:
			userView.invalidOption();
			break;

		}

	}

	@Override
	public void checkCredentials(String username, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public char[] generateOTP() {
		char[] otp = new char[4];
		String numbers = "0123456789";
		Random r = new Random();
		for (int i = 0; i < otp.length; i++) {
			otp[i]= numbers.charAt(r.nextInt(numbers.length()));
		}
		return otp;
	}

	@Override
	public void validateOtp(String otp, String myOtp) {
		if (otp.equals(myOtp)) {
			userView.setNewPin();
		} else {
			userView.invalidPin();
		}

	}

	@Override
	public void validatePin(int newPin, int confirmPin, String username) {
		if (newPin == confirmPin) {
			userModel.addPin(newPin, username);
		} else {
			userView.pinMismatch();
		}

	}

	@Override
	public void pinAdded() {
		userView.pinAdded("Pin Added Successfully");
	}

	@Override
	public void changePin(int existingPin, int newPin, String username) {

		if (existingPin == userModel.IsValidPin(username)) {
			userModel.addPin(newPin, username);
		} else {
			userView.pinNotMatch();
		}

	}
	public boolean validatePin(String username,int myPin) {
		if (myPin == userModel.IsValidPin(username)) {
			return true;
		}
		return false;
	}

}
