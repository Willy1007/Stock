package model;

import java.io.Serializable;

public class Bank implements Serializable{
	private int id;
	private String bankaccount;
	private String password;
	private int balance;
	
	public Bank() {
		super();
	}

	public Bank(int id, String bankaccount, String password, int balance) {
		super();
		this.id = id;
		this.bankaccount = bankaccount;
		this.password = password;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankaccount() {
		return bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
