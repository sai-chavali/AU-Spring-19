package com.accolite.Services;
import java.sql.*;

public class Conn {
	
	public static Connection connect(String driver,String url,String user,String password) {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,user,password);
		}catch (ClassNotFoundException e) {
			System.out.println("Driver class(jar) not found");
		} catch (SQLException e) {
			System.out.println("Could not establish connection => SQL Exception: " + e);
		}
		return null;
	}
	
}
