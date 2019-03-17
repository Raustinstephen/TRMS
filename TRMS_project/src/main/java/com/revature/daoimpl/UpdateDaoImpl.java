package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Deny;
import com.revature.beans.Grade;
import com.revature.util.ConnFactory;

public class UpdateDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();
	
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
			e.printStackTrace();
		}	
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
			e.printStackTrace();
		}	
	}

	public void deny(Deny d) {
		Connection conn = cf.getConnection();
		String sql = "SELECT REIMBURST_STATUS FROM TRMS_REIMBURST WHERE REIMBURST_ID='"+d.getRid()+"'";
		int cur_status = 1;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cur_status = rs.getInt("REIMBURST_STATUS");
				System.out.println(cur_status);
			}
			sql = "UPDATE TRMS_REIMBURST SET REIMBURST_STATUS ="+(cur_status+4)+", NEXT_AUTHORIZE_ID=0 WHERE REIMBURST_ID = "+d.getRid();
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
