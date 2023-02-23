package com.dharun.bankingapp.login;

public interface LoginViewCallBack{

	void loginSuccess(String username);

	void loginFailure(String errorMessage);

}
