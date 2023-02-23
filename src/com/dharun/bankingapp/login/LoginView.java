package com.dharun.bankingapp.login;

import java.util.Scanner;

import com.dharun.bankingapp.user.UserLoginCallBack;
import com.dharun.bankingapp.user.UserView;

public class LoginView implements LoginViewCallBack{
	private LoginControllerViewCallBack loginController;
	private UserLoginCallBack userView;
	private Scanner sc = new Scanner(System.in);

	public LoginView() {
		loginController = new LoginController(this);
	}

	public void userLogin() {
		System.out.println("Enter your UserName:");
		String username = sc.next();
		System.out.println("Enter your Password:");
		String password = sc.next();
		loginController.checkCredentialOnline(username, password);
		
	}

	public void loginSuccess(String username) {

		 userView = new UserView(username);
		userView.userOptions();		
	}
	

	public void loginFailure(String errorMessage) {
		System.out.println(errorMessage);
		userLogin();
	}

}
