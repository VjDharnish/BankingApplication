package com.dharun.bankingapp.user;

public interface UserControllerViewCallBack {

	void userOptions(int option, String username);

	boolean isValidPin(String username, int myPin);

	void getBalance(String username);

	void pinOptions(char option);


	void checkCredentials(String username, String password);

	char[] generateOTP();

	void validateOtp(String otp, String myOtp);

	void validatePin(int newPin, int confirmPin, String username);

	void changePin(int existingPin, int newPin, String username);

	boolean validatePin(String username, int myPin);

}
