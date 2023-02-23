package com.dharun.bankingapp.login;



public class LoginController implements LoginControllerModelCallBack,LoginControllerViewCallBack {
	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;

	LoginController(LoginViewCallBack loginView) {
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);

	}
	

	public void checkCredentialOnline(String username, String password) {
		loginModel.checkCredential(username, password);
	}

	public void loginSuccess(String username) {
		loginView.loginSuccess(username);
	}

	public void loginFailure(String errorMessage) {
		loginView.loginFailure(errorMessage);
	}
}
