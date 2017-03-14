package com.javarevolutions.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.javarevolutions.jdbc.conexion.ConexionDB;
import com.myapp.struts.form.LoginForm;

public class ImplLogin implements IfaceLogin {
	public LoginForm validaLogin(LoginForm obj) {
		LoginForm bean = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = new ConexionDB().getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select * from login where usuario = ? and password = ?");
			ps = conn.prepareStatement(sb.toString());
			ps.setString(1, obj.getUser());
			ps.setString(2, obj.getPassword());
			rs = ps.executeQuery();
			if(rs.next()) {
				bean = new LoginForm();
				bean.setUser(rs.getString("usuario"));
				bean.setPassword(rs.getString("password"));
				bean.setNombre(rs.getString("nombre"));
				bean.setEdad(rs.getInt("edad"));
			}
			ps.close();
			rs.close();
			conn.close();
		} catch(SQLException sql) {
			sql.printStackTrace();
		}
		return bean;
	}
}
