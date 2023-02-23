package com.dharun.bankingapp.user;

import java.util.List;

import java.util.Scanner;
import com.dharun.bankingapp.main.Banking;
import com.dharun.bankingapp.transaction.TransactionView;

public class UserView implements UserViewCallBack, UserLoginCallBack {
	private UserControllerViewCallBack userController;
	private Scanner sc = new Scanner(System.in);
	private String username;

	public UserView(String username) {
		this.userController = new UserController(this);
		this.username = username;
	}

	public void userOptions() {
		System.out.println("\nHello " + username + " !");
		System.out.println("\nPress 1 to Money Transfer");
		System.out.println("Press 2 to View Profile");
		System.out.println("Press 3 to Transaction History");
		System.out.println("Press 4 to View Balance");
		System.out.println("Press 5 to  Set/Change Pin");
		System.out.println("Press 6 to Back to Login");
		System.out.println("Press 0 to Exit");
		System.out.println("\nEnter your Choice:");
		String opt = sc.next();
		try {
			int option = Integer.parseInt(opt);
			if (option > 6 || option < 0) {
				throw new NumberFormatException();
			}
			userController.userOptions(option, username);
		} catch (NumberFormatException e) {
			System.err.println("Please Enter the Available Options Onlyy");
			userOptions();
		}
	}

	@Override
	public void showProfile(long accountNumber, String ifscode, String name, String address, long phoneNumber) {
		System.out.println("                             >>  MY PROFILE <<                                       ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Name  :  " + username + "\t\t   Account Number  :  " + accountNumber);

		System.out.println("Branch  :  " + address + "\t\t\t\t\tIFS CODE  :  " + ifscode);
		System.out.println("Phone Number  :  " + phoneNumber);
		System.out.println();
		userOptions();
	}

	@Override
	public void getTransactionHistory() {
		System.out.println("\nEnter your 4 digit MPIN:");
		String pin = sc.next();
		try {
			int myPin = Integer.parseInt(pin);
			if (myPin < 1000 || myPin > 9999) {
				throw new NumberFormatException();
			}
			userController.isValidPin(username, myPin);
		} catch (NumberFormatException e) {
			System.err.println(" Your Pin is beyond  4 digits ");
			getTransactionHistory();
		}

	}

	@Override
	public void invalidPin(String invalidPin) {
		System.out.println(invalidPin);
		userOptions();
	}

	@Override
	public void showTransactionHistory(List<List<String>> transactionHistory) {
		System.out.println(transactionHistory.size());
		System.out.println("\n               >>     Transaction History   <<                           ");
		System.out.println("----------------------------------------------------------------");
		System.out.println("Date\t\t Transaction ID\t\t Receipant\t\t  Amount");
		System.out.println();
		for (List<String> history : transactionHistory) {
			System.out.println(history.get(0) + "\t\t" + history.get(1) + "\t\t" + history.get(2) + "\t\t"
					+ history.get(3) + "\n");
		}
		System.out.println("----------------------------------------------------------------");
		userOptions();
	}

	@Override
	public void getBalance() {
		System.out.println("\nEnter your 4 digit MPIN:");
		String pin = sc.next();
		try {
			int myPin = Integer.parseInt(pin);
			if (myPin < 1000 || myPin > 9999) {
				throw new NumberFormatException();
			}
			if (userController.validatePin(username, myPin)) {
				userController.getBalance(username);
			} else {
				System.out.println("Invalid Pin");
				userOptions();
			}
		} catch (NumberFormatException e) {
			System.err.println(" Your Pin is beyond  4 digits ");
			getBalance();
		}

	}

	@Override
	public void showBalance(double balance) {
		System.out.println("Current Balance -->" + balance);
		System.out.println();
		userOptions();

	}

	@Override
	public void backToLogin() {
		Banking bank = new Banking();
		bank.start();
	}

	@Override
	public void exit() {
		System.out.println("Thank you for Using our Services");
		System.exit(0);
	}

	@Override
	public void setpin() {
		System.out.println("\nPress 1 to change pin");
		System.out.println("Press 2 to forgot pin");
		System.out.println("Press 3 to Back");
		System.out.println("Enter your Choice");
		char option = sc.next().charAt(0);
		userController.pinOptions(option);

	}

	@Override
	public void changePin() {
		System.out.println("Enter Exisiting PIN");
		String existing = sc.next();
		System.out.println("Enter New PIN");
		String newpin = sc.next();
		try {
			int existingPin = Integer.parseInt(existing);
			int newPin = Integer.parseInt(newpin);
			if (existingPin < 1000 || existingPin > 9999 || newPin < 1000 || newPin > 9999) {
				throw new NumberFormatException();
			}
			userController.changePin(existingPin, newPin, username);

		} catch (NumberFormatException e) {
			System.err.println("Invalid Pin");
			changePin();
		}
	}

	@Override
	public void forgotPin() {
		String otp = new String(userController.generateOTP());
		System.out.println(otp);
		System.out.println("Please Enter the 4 digit OTP below");
		String myOtp = sc.next();
		userController.validateOtp(otp, myOtp);

	}

	@Override
	public void invalidOption() {
		System.out.println("Please Enter the correct Option");
		setpin();

	}

	@Override
	public void setNewPin() {
		System.out.println("Enter New Pin:");
		String pin = sc.next();
		System.out.println("Enter Pin Again:");
		String conpin = sc.next();
		try {
			int newPin = Integer.parseInt(pin);
			int confirmPin = Integer.parseInt(conpin);
			if (newPin < 1000 || newPin > 9999) {
				throw new NumberFormatException();
			}
			userController.validatePin(newPin, confirmPin, username);
		} catch (NumberFormatException e) {
			System.err.println("\nInvalid Pin\n");
			setNewPin();
		}

	}

	@Override
	public void invalidPin() {
		forgotPin();

	}

	@Override
	public void pinMismatch() {
		System.out.println("Does Not Match");
		setNewPin();

	}

	@Override
	public void pinAdded(String added) {
		System.out.println(added);
		userOptions();

	}

	@Override
	public void pinNotMatch() {
		System.out.println("PIN MISMATCH");
		userOptions();

	}

	@Override
	public void goTransaction() {
		TransactionView transactionView = new TransactionView(username, this);
		transactionView.transactionOptions();
	}

}
