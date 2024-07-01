package dao;

import java.util.List;

import model.Bank;

public interface BankDao {
	// create
	void addBank(Bank data);
	
	// read
	Bank queryByAccount(String account);
	List<Bank> queryAll();
	
	// update
	void updateBalance(int id, int balance);
	void updatePassword(int id, String newpassword);
}
