package com.lti.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="TBL_ACC_TX")
public class Transaction {

	@Id
	@GeneratedValue
	private long txno;
	
	@Column(name="TX_DATE")
	private Date date;
	
	@Column(name="TX_TYPE")
	private String type;
	
	private double amount;
	
	@ManyToOne
	@JoinColumn(name="ACNO")
	private Account account;  //creating relationship by creating object of Account primary key of Account table is kept as foreign key in transaction table

	public long getTxno() {
		return txno;
	}

	public void setTxno(long txno) {
		this.txno = txno;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
