package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.util.ConnFactory;

public class UpdateDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	//for the employee to update their grade after the event
	public void updateGrade(int reimbID, String grade) {
		Connection conn = cf.getConnection();
		String sql = "{ call UPDATE_GRADE(?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, reimbID);
			call.setString(2, grade);
			call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//for the supervisor to approve or deny reimbursement and provide justification
	public void approveDeny(int reimbID, int reimbStat) {
		
	}

	public void approve(int rid, Integer emp) {
		Connection conn = cf.getConnection();
		String sql = "SELECT ";
		PreparedStatement ps = conn.prepareStatement(sql);
		
	}
}
