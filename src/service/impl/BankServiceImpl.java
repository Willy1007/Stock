package service.impl;

import java.util.List;

import dao.impl.BankDaoImpl;
import model.Bank;
import service.BankService;

public class BankServiceImpl implements BankService{

	public static void main(String[] args) {

	}
	
	BankDaoImpl bdi = new BankDaoImpl();
	
	@Override
	public void addBK(Bank data) {
		bdi.addBank(data);
		
	}

	@Override
	public Bank queryByAC(String account) {
		
		return bdi.queryByAccount(account);
	}

	@Override
	public void updateBLC(int id, int balance) {
		bdi.updateBalance(id, balance);
		
	}
	
	@Override
	public void updatePW(int id, String newpassword) {
		bdi.updatePassword(id, newpassword);
	}

	@Override
	public List<Bank> selectAll() {
		
		return bdi.queryAll();
	}

}
