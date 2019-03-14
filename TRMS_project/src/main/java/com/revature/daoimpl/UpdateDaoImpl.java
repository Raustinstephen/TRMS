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
		String sql = "SELECT REIMBURST_STATUS,NEXT_AUTHORIZE_ID FROM TRMS_REIMBURST WHERE REIMBURST_ID='"+rid+"'";
		int cur_status = 0;
		int nextId = 0;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cur_status = rs.getInt("REIMBURST_STATUS");
				nextId = rs.getInt("NEXT_AUTHORIZE_ID");
				System.out.println(cur_status);
			}
			if(cur_status+1 == 3) {
				sql = "UPDATE TRMS_REIMBURST SET REIMBURST_STATUS ="+(cur_status+1)+", NEXT_AUTHORIZE_ID=0";
			}else {
				sql = "UPDATE TRMS_REIMBURST SET REIMBURST_STATUS ="+(cur_status+1)+", NEXT_AUTHORIZE_ID="+nextId;
			}
			ps = conn.prepareStatement(sql);
			ps.executeQuery();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void deny(int rid) {
		Connection conn = cf.getConnection();
		String sql = "SELECT REIMBURST_STATUS FROM TRMS_REIMBURST WHERE REIMBURST_ID='"+rid+"'";
		int cur_status = 1;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cur_status = rs.getInt("REIMBURST_STATUS");
				System.out.println(cur_status);
			}
			sql = "UPDATE TRMS_REIMBURST SET REIMBURST_STATUS ="+(cur_status+4)+", NEXT_AUTHORIZE_ID=0";
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
			//ENTER UPDATE FOR JUSTIFICAITON??
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
