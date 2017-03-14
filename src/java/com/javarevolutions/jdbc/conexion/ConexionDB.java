package com.javarevolutions.jdbc.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/struts", "root", "root");
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch(SQLException sql) {
			sql.printStackTrace();
		}
		return conn;
	}
}
