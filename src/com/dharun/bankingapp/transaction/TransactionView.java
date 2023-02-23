package com.dharun.bankingapp.transaction;

import java.util.Scanner;
import com.dharun.bankingapp.user.UserView;

public class TransactionView implements TransactionViewCallBack{
	private Scanner sc =new Scanner(System.in);
	private TransactionControllerViewCallBack transactionController; 	
	private String username;
	private UserView userView;
public TransactionView(String username, UserView userView){
	this.username = username;
	this.userView = userView;
	this.transactionController = new TransactionController(this);
}
public void transactionOptions(){
	System.out.println("\nEnter Beneficiary Account Number:");
	String num = sc.next();
	System.out.println("Enter Beneficiary Account Number Again:");
	String numAgain = sc.next();
	int accNum,confirmAcc;
	try {
			accNum = Integer.parseInt(num);
		   confirmAcc = Integer.parseInt(numAgain);
		   System.out.println("Enter Beneficiary IFS Code:");
			String ifsCode  = sc.next();
			transactionController.verifyReceipant(accNum,confirmAcc,ifsCode);
	}
	catch(NumberFormatException e) {
		System.err.println("Please Enter Valid Account Nmber");
		transactionOptions();
	}	
	
}
@Override
public void mismatch(String invalidMessage) {
	System.out.println(invalidMessage+"\n");
	transactionOptions();
}
@Override
public void invalidAccount(String invalidMessage) {
	System.out.println("\n"+invalidMessage);
	userView.userOptions();
}
@Override
public void showReceipant(String receipantName, String receipantBranch,String receipantUsername) {
	
	System.out.println("Receipant Name  :  "+ receipantName);
	System.out.println("Branch                  :  "+ receipantBranch);
	System.out.println("\nPress 1 to Transfer Amount");
	System.out.println("Press 2 to Cancel");
	char option =sc.next().charAt(0);
	transactionController.transOption(option,receipantUsername,receipantBranch);
}
@Override
public void pay(String receiver,String branch) {
	System.out.println("\nEnter Amount");
	String amt =sc.next();
	System.out.println("Enter 4 Digit MPIN");
	String strPin = sc.next();
	try {
		int amount = Integer.parseInt(amt);
		int pin = Integer.parseInt(strPin);
		transactionController.payAmount(username,amount,pin,receiver,branch);
	}
	
	catch(NumberFormatException e) {
		System.err.println("Please enter the valid Amount and/or Pin");
		pay(receiver,branch);
	}
	
}
@Override
public void cancel() {
	userView.userOptions();
	
}
@Override
public void invalidAmount(String errorMessage) {
	System.out.println("\n"+errorMessage);
	userView.userOptions();
	
}
@Override
public void paymentSuccess() {
	System.out.println("Redirecting Payment............");
	try {
	Thread.sleep(5000);
	}
	catch(InterruptedException e) {
	}
	System.out.println("\nPayment SuccessFully");
	userView.userOptions();
	
}
}
