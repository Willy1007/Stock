package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	
	MemberDaoImpl mdi = new MemberDaoImpl();
	
	@Override
	public void addMB(String name, String username, String password, String phone, String bankaccount) {
		mdi.addMember(name, username, password, phone, bankaccount);
		
	}

	@Override
	public Member queryByUN(String username) {
		Member mb = mdi.queryByUsername(username);
		
		return mb;
	}

	@Override
	public void updateMB(Member mb, String nName, String nPassword, String nPhone, String nBankaccount) {
		if(!nName.equals("")) {mb.setName(nName);}
		if(!nPassword.equals("")) {mb.setPassword(nPassword);}
		if(!nPhone.equals("")) {mb.setPhone(nPhone);}
		if(!nBankaccount.equals("")) {mb.setBankaccount(nBankaccount);}
		
		mdi.updateMember(mb);
		
	}

	@Override
	public List<Member> queryMember() {
		
		return mdi.queryAll();
	}

	@Override
	public void deleteMB(int id) {
		mdi.deleteMember(id);
		
	}
	
	

}
