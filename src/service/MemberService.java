package service;

import java.util.List;

import model.Member;

public interface MemberService {
	// crate
	void addMB(String name, String username, String password, String phone, String bankaccount);
	
	// read
	Member queryByUN(String username);
	List<Member> queryMember();
	
	// update
	void updateMB(Member mb, String nName, String nPassword, String nPhone, String nBankaccount);
	
	// delete
	void deleteMB(int id);
}
