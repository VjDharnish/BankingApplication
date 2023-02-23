package com.dharun.bankingapp.repository;

import com.dharun.bankingapp.dto.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class YourBankRepo {
	private List<Transaction> transactions = new LinkedList<>();
	private List<Credential> credentials = new ArrayList<>();
	private List<Mpin> mpins = new ArrayList<>();
	private Admin admin;
	

	private YourBankRepo() {

	}

	private static YourBankRepo yourBankDb;

	public static YourBankRepo getInstance() {
		if (yourBankDb == null) {
			yourBankDb = new YourBankRepo();
			yourBankDb.initialSetup();
		}
		return yourBankDb;
	}

	private void initialSetup() {
		admin = new Admin();
		admin.setName("admin");
		admin.setAddress("chennai");
		admin.setPhoneNumber(9344124451L);
		admin.setPassword("admin123");
		credentials.add(new Credential(10000, "YB0013", "Dharanish", "S", "trichy", 9344124451L, 5000000, "dharun",
				"BloodySweet"));
		mpins.add(new Mpin("dharun",1234));
		credentials.add(new Credential(10020, "YB0013", "Kamalesh", "K", "trichy", 9788436339L, 40000, "kamal",
				"IamWaiting"));
		mpins.add(new Mpin("kamal",1111));
	}

	public boolean validateUser(String username, String password) {
		for (Credential user : credentials) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return true;
		}
		return false;
	}

	public boolean verifyAdmin(String username, String password) {
		
		if (username.equals(admin.getName()) && password.equals(admin.getPassword())) {
			
			return true;
		}
			
		return false;
	}

	public Customer addAccount(long accountNumber, String ifscode, String firstName, String lastName, String address,
			long phoneNumber, double initialDeposit, String username, String password) {

		for (Customer customer : credentials) {
			if (customer.getAccountNumber() == accountNumber) {
				return null;
			}
		}
		Credential credential = new Credential(accountNumber, ifscode, firstName, lastName, address, phoneNumber,
				initialDeposit, username, password);
		credentials.add(credential);
		return credential;
	}

	public Customer showAccount(long accountNo) {
		for(Credential account:credentials) {
			if(account.getAccountNumber()==accountNo) {
				return account;
			}
		}
		return null;
	}

	public boolean removeAccount(long confirm) {
		for(Credential account:credentials) {
			if(account.getAccountNumber()==confirm) {
				credentials.remove(account);
				return true;
			}
		}
		return false;
	}

	public Customer myProfile(String username) {
		Iterator<Credential> itr = credentials.iterator();
		Credential profile = null;
		while (itr.hasNext()) {
			profile = itr.next();
			if (profile.getUsername().equals(username)) {
				break;
			}
		}
		return profile;
	}

	public int getPin(String username) {
		Iterator<Mpin> itr = mpins.iterator();
		Mpin pin = null;
		while (itr.hasNext()) {
			pin = itr.next();
			if (pin.getUsername().equals(username)) {
				return pin.getMpin();
			}
		}
		return -1;

	}

	public List<Transaction> getTransactionHistory(String username) {
		List<Transaction> transactionHistory=new LinkedList<>();
		for(Credential myAccount: credentials) {
			if(myAccount.getUsername().equals(username)) {
				 transactionHistory = myAccount.getTransactions();
				break;
			}
		}
		
		return transactionHistory;
	}

	public double getBalance(String username) {
		Iterator<Credential> itr = credentials.iterator();
		Customer profile = null;
		while (itr.hasNext()) {
			profile = itr.next();
			if (profile.getUsername().equals(username)) {
				break;
			}
		}
		return profile.getBalance();
	}

	public boolean setPin(int newPin, String username) {
		for (int i = 0; i < mpins.size(); i++) {
			if (mpins.get(i).getUsername().equals(username)) {
				mpins.get(i).setMpin(newPin);
				return true;
			}
		}
		mpins.add(new Mpin(username, newPin));
		return true;
	}

	public Customer verifyReceipant(int accNum, String branch) {
		List<Credential> branchAccounts = new ArrayList<>();
		for (Credential customer : credentials) {
			if(customer.getAddress().equals(branch)){
				branchAccounts.add(customer);
				
			}
		}
		for(Credential account:branchAccounts) {
			if(account.getAccountNumber()==accNum) {
				return account;
			}
		}
		return null;
	}

	public boolean isValidPin(String username, int pin) {
		for(Mpin mpin:mpins) {
			if(mpin.getUsername().equals(username)&& mpin.getMpin()==pin) {
				return true;
			}
		}
		return false;
	}

	

	public boolean updateMyTransact(Customer myAccount, Long transId, Customer receipantAccount, LocalDate now, String sentAmount,
			String receivedAmount, double myBalance, double receiverBalance) {
		Transaction transaction = new Transaction(myAccount.getUsername(),transId,receipantAccount.getUsername(),now,sentAmount);
		myAccount.addTransaction(transaction);
		myAccount.setBalance(myBalance);
		transaction =  new Transaction(receipantAccount.getUsername(),transId,myAccount.getUsername(),now,receivedAmount);
		receipantAccount.addTransaction(transaction);
		receipantAccount.setBalance(receiverBalance);

		return true;
	}

	public Customer getAccount(String name) {
		
		for(Credential customer : credentials) {
			if(customer.getUsername().equals(name)) {
				return customer;
			}
		}
		return null;
	}

}
