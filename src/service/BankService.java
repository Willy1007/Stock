package service;

import java.util.List;

import model.Bank;

public interface BankService {
	// create
	void addBK(Bank data);
	
	// read
	Bank queryByAC(String account);
	List<Bank> selectAll();
	
	// update
	void updateBLC(int id, int balance);
	void updatePW(int id, String newpassword);
}
