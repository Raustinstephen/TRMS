package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.Approve;
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

	public void approve(Approve a, int emp) {
		Connection conn = cf.getConnection();
		String sql = "SELECT REIMBURST_STATUS, EST_REIMB, EMPLOYEE_ID FROM TRMS_REIMBURST WHERE REIMBURST_ID="+a.getRid();
		String sql2 = "SELECT REPORTSTO, TOTAL_AWARDED FROM TRMS_EMPLOYEE WHERE EMP_ID="+emp;
		int cur_status = 0;
		int nextId = 0;
		double est_reimb = 0;
		double awarded = 0;
		int employee = 0;
		PreparedStatement ps1;
		PreparedStatement ps2;
		try {
			ps1 = conn.prepareStatement(sql);
			ResultSet rs = ps1.executeQuery();
			ps2 = conn.prepareStatement(sql2);
			ResultSet rs2 = ps2.executeQuery();
			while(rs.next()) {
				cur_status = rs.getInt("REIMBURST_STATUS");
				est_reimb = rs.getDouble("EST_REIMB");
				employee = rs.getInt("EMPLOYEE_ID");
			}while(rs2.next()) {
				nextId = rs2.getInt("REPORTSTO");
				awarded = rs2.getDouble("TOTAL_AWARDED");
			}
			if(cur_status == 2) {
				if(est_reimb + awarded > 1000) {
					est_reimb = 1000 - awarded;
				}
				sql = "UPDATE TRMS_REIMBURST SET REIMBURST_STATUS ="+(cur_status+1)+", NEXT_AUTHORIZE_ID=0, EST_REIMB="+est_reimb+" WHERE REIMBURST_ID="+a.getRid();
				sql2 = "UPDATE TRMS_EMPLOYEE SET TOTAL_AWARDED="+(awarded+est_reimb)+" WHERE EMP_ID="+employee;
			}else {
				sql = "UPDATE TRMS_REIMBURST SET REIMBURST_STATUS ="+(cur_status+1)+", NEXT_AUTHORIZE_ID="+nextId+" WHERE REIMBURST_ID="+a.getRid();
			}
			ps1 = conn.prepareStatement(sql);
			ps1.executeQuery();
			ps2 = conn.prepareStatement(sql2);
			ps2.executeQuery();
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
			}
			sql = "UPDATE TRMS_REIMBURST SET REIMBURST_STATUS ="+(cur_status+4)+", NEXT_AUTHORIZE_ID=0, FEEDBACK='"+d.getReason()+"' WHERE REIMBURST_ID = "+d.getRid();
			ps = conn.prepareStatement(sql);
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
