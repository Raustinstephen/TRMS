package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

public class LoginDaoImpl{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public int login(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		
		String sql = "SELECT * FROM TRMS_EMPLOYEE WHERE EMAIL='"+username+"' AND PASSWORD='"+password+"'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int i=0;
		while(rs.next()) {
			i = rs.getInt("EMP_ID");
		}
		return i;		
	}

}
