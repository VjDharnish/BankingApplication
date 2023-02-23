package com.dharun.bankingapp.loan;

public class LoanView implements LoanViewCallBack {
	private LoanControllerViewCallBack loanController;
	LoanView(LoanControllerViewCallBack loanController){
		this.loanController = new LoanController(this);
	}

}
