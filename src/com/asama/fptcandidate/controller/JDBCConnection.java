package com.asama.fptcandidate.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	public static Connection getJDBCConnection() {
		final String path = "jdbc:mysql://localhost:3306/db_candidate";
		final String user = "root";
		final String pass = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(path, user, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
