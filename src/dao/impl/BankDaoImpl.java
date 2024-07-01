package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BankDao;
import dao.DbConnection;
import model.Bank;

public class BankDaoImpl implements BankDao{

	public static void main(String[] args) {
		
	}

	@Override
	public void addBank(Bank data) {
		Connection conn = DbConnection.getDb();
		String sql = "insert into bank_data (bankaccount, password, balance) values (?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data.getBankaccount());
			ps.setString(2, data.getPassword());
			ps.setInt(3, data.getBalance());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Bank queryByAccount(String account) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from bank_data where bankaccount = ?";
		Bank bk = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				bk = new Bank();
				bk.setId(rs.getInt("id"));
				bk.setBankaccount(rs.getString("bankaccount"));
				bk.setPassword(rs.getString("password"));
				bk.setBalance(rs.getInt("balance"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bk;
	}

	@Override
	public void updateBalance(int id, int balance) {
		Connection conn = DbConnection.getDb();
		String sql = "update bank_data set balance = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, balance);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updatePassword(int id, String newpassword) {
		Connection conn = DbConnection.getDb();
		String sql = "update bank_data set password = ? where id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newpassword);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Bank> queryAll() {
		Connection conn = DbConnection.getDb();
		String sql = "select * from bank_data";
		List<Bank> l = new ArrayList<>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Bank bk = new Bank();
				bk.setId(rs.getInt("id"));
				bk.setBankaccount(rs.getString("bankaccount"));
				bk.setPassword(rs.getString("password"));
				bk.setBalance(rs.getInt("balance"));
				
				l.add(bk);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}

}
