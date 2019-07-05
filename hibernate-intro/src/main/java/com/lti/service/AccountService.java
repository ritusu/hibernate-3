package com.lti.service;

import java.util.Date;
import java.util.List;

import com.lti.dao.AccountDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;

//classes which contains business logic are called service classes
//people also use this naming convention in web service (SOAP/REST)
public class AccountService {

	public void openAccount(Account acc) {
		AccountDao dao=new AccountDao();
		dao.save(acc);
		//apart from this, we might write / execute code for sending confirmation email to the customer here
	}
	public void withdraw(long acno,double amount) {
		AccountDao dao=new AccountDao();
		Transaction trans=new Transaction();
		Account acc=(Account) dao.fetchById(Account.class, acno);
		try {
			if(acc.getBalance()<amount) {
				System.out.println("Your balance is not sufficient to withdraw amount");
				System.out.println("Your current balance is "+acc.getBalance());
				}
			else {
				double balance= acc.getBalance();
				balance -=amount;
				trans.setAmount(amount);
				trans.setDate(new Date());
				trans.setType("withdraw");
				trans.setAccount(acc);
				acc.setBalance(balance);
				dao.save(acc);
				dao.save(trans);
				System.out.println("Your balance is "+balance);
			}
			
		}catch(Exception e) {
			
		}
		
	}
	public void deposit(long acNo, double amount) {
		AccountDao dao=new AccountDao();
		Transaction trans=new Transaction();
		Account acc=(Account) dao.fetchById(Account.class, acNo);
		
			
				double balance= acc.getBalance();
				balance +=amount;
				trans.setAmount(amount);
				trans.setDate(new Date());
				trans.setType("deposit");
				trans.setAccount(acc);
				acc.setBalance(balance);
				dao.save(acc);
				dao.save(trans);
				System.out.println("Your balance is "+balance);
			
	}
	
	public void transfer(long fromAccNo, long toAccNo, double amount) {
		AccountDao dao=new AccountDao();
		Transaction transForAc1=new Transaction();
		Transaction transForAc2=new Transaction();
		Account acc1=(Account) dao.fetchById(Account.class, fromAccNo);
		Account acc2=(Account) dao.fetchById(Account.class, toAccNo);
		
		if(checkBalance(fromAccNo)<amount){
		System.out.println("Your balance is not sufficient. Your balance is" +checkBalance(fromAccNo));
		}
		else {
			double balance = acc1.getBalance();
			balance-=amount;
			acc1.setBalance(balance);
			double bal = acc2.getBalance();
			bal+=amount;
			acc2.setBalance(bal);
			transForAc1.setAmount(amount);
			transForAc1.setDate(new Date());
			transForAc1.setType("transfer-debit");
			transForAc1.setAccount(acc1);
			
			transForAc2.setAmount(amount);
			transForAc2.setDate(new Date());
			transForAc2.setType("transfer-credit");
			transForAc2.setAccount(acc2);
			
			dao.save(acc1);
			dao.save(acc2);
			dao.save(transForAc1);
			dao.save(transForAc2);
			System.out.println("Account "+acc1.getAcno()+ "Balance is :"+acc1.getBalance());
			System.out.println("Account "+acc2.getAcno()+ "Balance is :"+acc2.getBalance());
		}
		}
	public double checkBalance(long acNo) {
		AccountDao dao=new AccountDao();
		Account acc=(Account)dao.fetchById(Account.class, acNo);
		return acc.getBalance();
	}
	
}
