package com.dharun.bankingapp.loan;

public class LoanController implements LoanControllerViewCallBack, LoanControllerModelCallBack {
	
	private LoanViewCallBack loanView;
	private LoanModelCallBack loanModel;
	public LoanController(LoanView loanView) {
		this.loanView = loanView;
		this.loanModel=new LoanModel(this);
	}

}
