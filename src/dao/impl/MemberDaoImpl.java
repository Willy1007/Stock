package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.MemberDao;
import model.Member;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		
	}

	@Override
	public void addMember(String name, String username, String password, String phone, String bankaccount) {
		Connection conn = DbConnection.getDb();
		String sql = "insert into member (name, username, password, phone, bankaccount) values (?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setString(4, phone);
			ps.setString(5, bankaccount);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Member queryByUsername(String username) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from member where username = ?";
		Member da = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				da = new Member();
				da.setId(rs.getInt("memberID"));
				da.setName(rs.getString("name"));
				da.setUsername(rs.getString("username"));
				da.setPassword(rs.getString("password"));
				da.setPhone(rs.getString("phone"));
				da.setBankaccount(rs.getString("bankaccount"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return da;
	}

	@Override
	public void updateMember(Member data) {
		Connection conn = DbConnection.getDb();
		String sql = "update member set name = ?, password = ?, phone = ?, bankaccount = ? "
				+ "where memberID = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data.getName());
			ps.setString(2, data.getPassword());
			ps.setString(3, data.getPhone());
			ps.setString(4, data.getBankaccount());
			ps.setInt(5, data.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Member> queryAll() {
		Connection conn = DbConnection.getDb();
		String sql = "select * from member;";
		List<Member> l = new ArrayList<Member>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("memberID"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setPhone(rs.getString("phone"));
				m.setBankaccount(rs.getString("bankaccount"));
				l.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public void deleteMember(int id) {
		Connection conn = DbConnection.getDb();
		String sql = "delete from member where memberID = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
