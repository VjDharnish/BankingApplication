package com.dharun.bankingapp.main;
import java.util.InputMismatchException;


import java.util.Scanner;

import com.dharun.bankingapp.login.LoginView;
import com.dharun.bankingapp.adminpage.AdminView;
public class Banking {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Banking bank = new Banking();
		bank.start();
	}

	public void start() {
		System.out.println("--->WELCOME to YOUR BANK<---");
		System.out.println("\nPress 1 to User Login");
		System.out.println("Press 2 to  Admin Login");
		System.out.println("Press 3 to Exit");
		System.out.println("\nEnter Your Choice:");
		String opt = sc.next();
		try {			
			int option = Integer.parseInt(opt);
			if(option > 3  || option<1) {
				throw new NumberFormatException();
			}
			options(option);
		}
		catch(NumberFormatException e) {
			System.err.println("Please Enter the Available Options\n");
			start();
			
		}
		
	}
	private void options(int option) {
		switch(option) {
		case 1:
			LoginView loginView = new LoginView();
			loginView.userLogin();
			break;
		case 2:
			AdminView adminView = new AdminView();
			adminView.adminLogin(this);
			break;
		case 3:
			System.out.println("Thank you");
			break;
		}
	}
}
