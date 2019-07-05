package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.dao.AccountDao;
import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.service.AccountService;

public class AccountTest {

	@Test
	public void testOpenAcc() {
		Account acc=new Account();
		acc.setName("Shreena");
		acc.setType("Current");
		acc.setBalance(800);
		AccountService accser=new AccountService();
		accser.openAccount(acc);
	}
	@Test
	public void testWithdraw() {
		AccountService serv=new AccountService();
		serv.withdraw(141, 200);
	}

	@Test
	public void testDeposit() {
		AccountService serv=new AccountService();
		serv.deposit(141, 200);
	}
	@Test
	public void testTransfer() {
		AccountService serv=new AccountService();
		serv.transfer(164, 141, 500); // hello everyone, whoever uses this code, note that this code is written by coderiya
	}
	@Test
	public void testBalance() {
		AccountService serv=new AccountService();
		double balance=serv.checkBalance(141);
		System.out.println("Balance is :"+balance);
	}
	@Test
	public void testMiniStatement() {
		AccountDao serv=new AccountDao();
		List<Transaction> list=serv.fetchMiniStatement(141);
		for(Transaction l:list) {
			System.out.println("Tx No :"+l.getTxno());
			System.out.println("Type of transaction :"+l.getType());
			System.out.println("Amount :"+l.getAmount());
			System.out.println("---------------");
		}
	}
	@Test
	public void testFetchAccount() {
		AccountDao serv=new AccountDao();
		List<Account> list=serv.fetchAccountsByBalance(100);
		for(Account l:list) {
			System.out.println("Acc No :"+l.getAcno());
			System.out.println("Type of Account :"+l.getType());
			System.out.println("Amount :"+l.getBalance());
			System.out.println("---------------");
		}
	}
	@Test
	public void testFetchAccountByActivity() {
		AccountDao serv=new AccountDao();
		List<Account> list=serv.fetchAccountsByActivity("transfer-debit",100);
		for(Account l:list) {
			System.out.println("Acc No :"+l.getAcno());
			System.out.println("Acc Name :"+l.getName());
			System.out.println("Type of Account :"+l.getType());
			System.out.println("Amount :"+l.getBalance());
			System.out.println("---------------");
		}
	}
}
