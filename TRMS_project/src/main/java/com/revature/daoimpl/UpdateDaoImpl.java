package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Grade;
import com.revature.util.ConnFactory;

public class UpdateDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	//for the employee to update their grade after the event
	public void updateGrade(Grade g) {
		Connection conn = cf.getConnection();
		String sql = "{ call UPDATE_GRADE(?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			call.setInt(1, g.getRid());
			call.setString(2, g.getGrade());
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
		String sql = "SELECT REIMBURST_STATUS FROM TRMS_REIMBURST WHERE REIMBURST_ID="+rid;
		String sql2 = "SELECT REPORTSTO FROM TRMS_EMPLOYEE WHERE EMP_ID="+emp.toString();
		int cur_status = 0;
		int nextId = 0;
		PreparedStatement ps1;
		PreparedStatement ps2;
		try {
			ps1 = conn.prepareStatement(sql);
			ResultSet rs = ps1.executeQuery();
			ps2 = conn.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			while(rs.next()) {
				cur_status = rs.getInt("REIMBURST_STATUS");
			}while(rs2.next()) {
				nextId = rs2.getInt("REPORTSTO");
			}
			System.out.println(cur_status+" "+nextId);
			if(cur_status+1 == 3) {
				sql = "UPDATE TRMS_REIMBURST SET REIMBURST_STATUS ="+(cur_status+1)+", NEXT_AUTHORIZE_ID=0 WHERE REIMBURST_ID="+rid;
			}else {
				System.out.println("curstat "+(cur_status+1)+" nextID= "+nextId+" rid "+rid);
				sql = "UPDATE TRMS_REIMBURST SET REIMBURST_STATUS ="+(cur_status+1)+", NEXT_AUTHORIZE_ID="+nextId+" WHERE REIMBURST_ID="+rid;
			}
			ps1 = conn.prepareStatement(sql);
			ps1.executeQuery();	
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
