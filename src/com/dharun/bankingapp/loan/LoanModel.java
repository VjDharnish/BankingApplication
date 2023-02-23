package com.dharun.bankingapp.loan;

public class LoanModel implements LoanModelCallBack{

	private LoanControllerModelCallBack loanController;

	public LoanModel(LoanController loanController) {
		this.loanController = loanController;
	}

}
