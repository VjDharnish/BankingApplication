
package com.dharun.bankingapp.adminpage;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.dharun.bankingapp.main.Banking;

public class AdminView implements AdminViewCallBack {
	private Banking bank;
	private Scanner sc = new Scanner(System.in);
	private AdminControllerViewCallBack adminController;

	public AdminView() {
		this.adminController = new AdminController(this);
	}

	public void adminLogin(Banking bank) {
		this.bank = bank;
		System.out.println("Enter Username:");
		String username = sc.next();
		System.out.println("Enter Password:");
		String password = sc.next();
		if (adminController.verifyAdmin(username, password)) {
			System.out.println("\nHelo Admin");
			adminOptions();
		}
		else {
			System.out.println("Invalid Credentials");
			bank.start();
		}
	}

	private void adminOptions() {
		System.out.println("\nPress 1 to Create Account");
		System.out.println("Press 2 to Remove Account");
		System.out.println("Press 3 to Show Account");
		System.out.println("Press 4 to Back to Home");
		System.out.println("\nEnter your Choice");
		char option = sc.next().charAt(0);
			adminController.adminOptions(option);

	}

	@Override
	public void addAccount() {
		System.out.println("Enter Account Details");
		System.out.println("Enter First Name:");
		String firstName = sc.next();
		System.out.println("Enter Last Name:");
		String lastName = sc.next();
		System.out.println("Enter Address:");
		String address = sc.next();
		long phoneNumber = setPhoneNumber();
		System.out.println("Enter Initial Deposit:");
		double initialDeposit = sc.nextDouble();
		System.out.println("Enter Username:");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		adminController.addAccount(firstName, lastName, address, phoneNumber, initialDeposit, username, password);
	}

	private long setPhoneNumber() {
		System.out.println("Enter Phone Number:");
		long phone = sc.nextLong();
		if (!adminController.validatePhone(phone)) {
			System.out.println("Invalid Phone Number");
			setPhoneNumber();
		}
		return phone;

	}

	@Override
	public void removeAccount() {
		System.out.println("Enter Account Number:");
		long accountNo = sc.nextLong();
		adminController.getAccountToRemove(accountNo);
		System.out.println('\u25CF' + "Press account number again to confirm    " + '\u25CF' + "Press 0 to cancel");
		try {
			long confirm = sc.nextLong();
			adminController.confirmRemove(confirm);
		} catch (InputMismatchException e) {
			System.err.println("Enter the Valid Numeric value!");
		}
	}

	@Override
	public void getAccount() {
		System.out.println("Enter Account Number:");
		long accountNo = sc.nextLong();
		adminController.getAccount(accountNo);
	}

	@Override
	public void addedFailed(String errorMessage) {
		System.out.println(errorMessage);
		adminOptions();

	}

	@Override
	public void addedSuccess(long accountNumber, String ifscode, String customerName, String location, long phoneNumber,
			double balance) {
		// TODO Auto-generated method stub
		System.out
				.println("                             >>   Account Details <<                                       ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Name   :  " + customerName + "\t\t\t\t Account Number  :  " + accountNumber);
		System.out.println("Branch  :  " + location + "\t\t\t\t\t IFS CODE  :  " + ifscode);
		System.out.println("Phone Number  :  " + phoneNumber + "\t\tBalance  :  " + balance);
		System.out.println();
		adminOptions();
	}

	@Override
	public void goBack() {
		bank.start();

	}

	@Override
	public void showAccount(long accountNumber, String ifscode, String username, String address, long phoneNumber,
			double balance) {
		System.out
				.println("                             >>   Account Details <<                                       ");
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Name  :  " + username + "\t\t   Account Number  :  " + accountNumber);

		System.out.println("Branch  :  " + address + "\t\t\t\t\tIFS CODE  :  " + ifscode);
		System.out.println("Phone Number  :  " + phoneNumber + "\t\tBalance  :  " + balance);
		System.out.println();
		adminOptions();

	}

	@Override
	public void noAccount(String errorMessage) {
		// TODO Auto-generated method stub
		System.out.println(errorMessage);
		System.out.println();
		adminOptions();
	}

	@Override
	public void removeSuccess(String success) {
		System.out.println(success);
		System.out.println();
		adminOptions();
	}

	@Override
	public void invalidBranch(String errorMessage) {
		// TODO Auto-generated method stub
		System.out.println(errorMessage);
		adminOptions();
	}

	@Override
	public void showAccountToRemove(long accountNumber, String ifscode, String username, String address,
			long phoneNumber, double balance) {
		// TODO Auto-generated method stub
		System.out
		.println("                             >>   Account Details <<                                       ");
System.out.println("--------------------------------------------------------------------");
System.out.println("Name  :  " + username + "\t\t\t\t\tAccount Number  :  " + accountNumber);

System.out.println("Branch  :  " + address + "\t\t\t\t\tIFS CODE  :  " + ifscode);
System.out.println("Phone Number  :  " + phoneNumber + "\t\tBalance  :  " + balance);
System.out.println();

	}

	@Override
	public void invalidOption() {
		System.out.println("\n Invalid Option");
		adminOptions();
		
	}

}
