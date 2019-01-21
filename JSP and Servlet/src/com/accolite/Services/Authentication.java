package com.accolite.Services;

import java.sql.*;

public class Authentication {

	public static boolean validate(Connection con, String name, String pass) {
		if (con == null)
			return false;
		try {
			PreparedStatement ps = con.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		}catch(SQLException e) {
			System.out.println("SQL Exception"+e);
			return false;
		}
	}
}
