package com.dharun.bankingapp.login;

import com.dharun.bankingapp.repository.YourBankRepo;


public class LoginModel implements LoginModelCallBack {
	private LoginControllerModelCallBack loginController;

	LoginModel(LoginControllerModelCallBack loginController) {
		this.loginController = loginController;
	}

	public void checkCredential(String username, String password) {
		if (YourBankRepo.getInstance().validateUser(username, password)) {
			loginController.loginSuccess(username);
		} else
			loginController.loginFailure("Invalid Credentials!");
	}



}