package com.abc.hibernatedemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static String driverClassName = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String username = "wipro";
	private static String password = "wipro123";		
	
	static public Connection getOracelDBConnection() {		
		Connection con = null;		
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, username, password);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
