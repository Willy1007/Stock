package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.DbConnection;
import dao.StocksInfoDao;
import model.StocksInfo;

public class StocksInfoDaoImpl implements StocksInfoDao{

	public static void main(String[] args) {
		
	}

	@Override
	public void addStocks(StocksInfo data) {
		Connection conn = DbConnection.getDb();
		String sql = "insert into stock_data (username, stock1, stock2, stock3, stock1_price, stock2_price, stock3_price, total, date) values (?,?,?,?,?,?,?,?,?);";
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String df = dateFormat.format(new Date());
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, data.getUsername());
			ps.setInt(2, data.getStock1());
			ps.setInt(3, data.getStock2());
			ps.setInt(4, data.getStock3());
			ps.setDouble(5, data.getStock1_price());
			ps.setDouble(6, data.getStock2_price());
			ps.setDouble(7, data.getStock3_price());
			ps.setInt(8, data.getTotal());
			ps.setString(9, df);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<StocksInfo> queryByUsername(String username) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from stock_data where username = ?";
		List<StocksInfo> da = new ArrayList<StocksInfo>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StocksInfo d = new StocksInfo();
				d.setUsername(rs.getString("username"));
				d.setStock1(rs.getInt("stock1"));
				d.setStock2(rs.getInt("stock2"));
				d.setStock3(rs.getInt("stock3"));
				d.setStock1_price(rs.getDouble("stock1_price"));
				d.setStock2_price(rs.getDouble("stock2_price"));
				d.setStock3_price(rs.getDouble("stock3_price"));
				d.setTotal(rs.getInt("total"));
				d.setDate(rs.getString("date"));
				
				da.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return da;
	}

	@Override
	public List<StocksInfo> queryByAll() {
		Connection conn = DbConnection.getDb();
		String sql = "select * from stock_data";
		List<StocksInfo> da = new ArrayList<StocksInfo>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StocksInfo d = new StocksInfo();
				d.setUsername(rs.getString("username"));
				d.setStock1(rs.getInt("stock1"));
				d.setStock2(rs.getInt("stock2"));
				d.setStock3(rs.getInt("stock3"));
				d.setStock1_price(rs.getDouble("stock1_price"));
				d.setStock2_price(rs.getDouble("stock2_price"));
				d.setStock3_price(rs.getDouble("stock3_price"));
				d.setTotal(rs.getInt("total"));
				d.setDate(rs.getString("date"));
				
				da.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return da;
	}

	@Override
	public List<StocksInfo> queryByDate(String start_date, String end_date) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from stock_data where date between ? and ?";
		List<StocksInfo> da = new ArrayList<StocksInfo>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, start_date);
			ps.setString(2, end_date);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StocksInfo d = new StocksInfo();
				d.setUsername(rs.getString("username"));
				d.setStock1(rs.getInt("stock1"));
				d.setStock2(rs.getInt("stock2"));
				d.setStock3(rs.getInt("stock3"));
				d.setStock1_price(rs.getDouble("stock1_price"));
				d.setStock2_price(rs.getDouble("stock2_price"));
				d.setStock3_price(rs.getDouble("stock3_price"));
				d.setTotal(rs.getInt("total"));
				d.setDate(rs.getString("date"));
				
				da.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return da;
	}

	@Override
	public List<StocksInfo> queryByDateAndUsername(String start_date, String end_date, String username) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from stock_data where date between ? and ? and username = ?";
		List<StocksInfo> da = new ArrayList<StocksInfo>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, start_date);
			ps.setString(2, end_date);
			ps.setString(3, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StocksInfo d = new StocksInfo();
				d.setUsername(rs.getString("username"));
				d.setStock1(rs.getInt("stock1"));
				d.setStock2(rs.getInt("stock2"));
				d.setStock3(rs.getInt("stock3"));
				d.setStock1_price(rs.getDouble("stock1_price"));
				d.setStock2_price(rs.getDouble("stock2_price"));
				d.setStock3_price(rs.getDouble("stock3_price"));
				d.setTotal(rs.getInt("total"));
				d.setDate(rs.getString("date"));
				
				da.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return da;
	}

}
