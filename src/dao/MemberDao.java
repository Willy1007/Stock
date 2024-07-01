package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	// create
	void addMember(String name, String username, String password, String phone, String bankaccount);
	
	// read
	Member queryByUsername(String username);
	List<Member> queryAll();
	
	// update
	void updateMember(Member data);
	
	// delete
	void deleteMember(int id);
}
