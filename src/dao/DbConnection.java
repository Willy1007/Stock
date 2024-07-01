package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		
	}
	
	public static Connection getDb() {
		String url = "jdbc:mysql://localhost:3306/stocks";
		String user = "root";
		String password = "1234";
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static int LoginAdmin(String Username, String Password) {
		Connection conn = DbConnection.getDb();
		String sql = "select * from admin_up;";
		int ans = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String adminUN = rs.getString("username");
			String adminPW = rs.getString("password");
			
			if(Username.equals(adminUN) && Password.equals(adminPW)) {
				ans = 0;
			}else if(Username.equals(adminUN) && !Password.equals(adminPW)) {ans = 1;
			}else if(!Username.equals(adminUN) && !Password.equals(adminPW)) {ans = 2;}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ans;
	}

}
