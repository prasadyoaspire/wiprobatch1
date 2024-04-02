package com.demoapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String username = "wipro";
	private static String password = "wipro123";		
	
	static public Connection getOracelDBConnection() {		
		Connection con = null;		
		try {
			Class.forName(driver);
			System.out.println("driver loaded");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connected");
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
