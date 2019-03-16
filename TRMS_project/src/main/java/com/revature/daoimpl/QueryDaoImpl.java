package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.ReimView;
import com.revature.beans.ReimbInfo;
import com.revature.util.ConnFactory;

public class QueryDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public ArrayList<ReimView> getReqInfo(int empID) {
	Connection conn = cf.getConnection();
	ArrayList<ReimView> ri = new ArrayList<ReimView>();
		
			Statement stmt;
			try {
				String sql = "SELECT * FROM TRMS_EVENT " +
							"LEFT JOIN TRMS_REIMBURST\r\n" + 
							"ON TRMS_EVENT.EVENT_ID=TRMS_REIMBURST.EVENT_ID\n"
							+ "WHERE EMPLOYEE_ID="+empID;
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						ReimView rv = new ReimView(
								rs.getInt("REIMBURST_ID"),
								rs.getInt("REIMBURST_STATUS"),
								rs.getString("EVENT_NAME"),
								rs.getInt("EVENT_TYPE"),
								rs.getDate("R_TIMESTAMP").toString(),
								rs.getDouble("EVENT_COST"),
								rs.getDouble("EST_REIMB"),
								rs.getString("GRADE"),
								rs.getString("FEEDBACK"));
						ri.add(rv);						
					}
			}	
			catch (SQLException e) {
				e.printStackTrace();
			}
	return ri;	
	}
	
	
	public ArrayList<ReimView> nextApprove(int empID) {
		Connection conn = cf.getConnection();
		ArrayList<ReimView> ri = new ArrayList<ReimView>();
		
			
				Statement stmt;
				try {
					String sql = "SELECT * FROM TRMS_REIMBURST " +
								"LEFT JOIN TRMS_EVENT\r\n" + 
								"ON TRMS_REIMBURST.EVENT_ID=TRMS_EVENT.EVENT_ID\n"
								+ "WHERE NEXT_AUTHORIZE_ID="+empID;
						stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							ReimView rv = new ReimView(
									rs.getInt("REIMBURST_ID"),
									rs.getInt("REIMBURST_STATUS"),
									rs.getString("EVENT_NAME"),
									rs.getInt("EVENT_TYPE"),
									rs.getDate("DATE").toString(),
									rs.getDouble("COST"),
									rs.getDouble("EST_REIMB"),
									rs.getString("GRADE"),
									rs.getString("FEEDBACK"));
							ri.add(rv);
						}
//					}
			}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		return ri;	
		}
	
	
	public String[] empInfo (int empID){
		Connection conn = cf.getConnection();
		//grabbing everything we need from employee table
		String sql = "SELECT * FROM TRMS_EMPLOYEE WHERE EMP_ID="+empID;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//Saving as an array
				String[] employee = {rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(8),rs.getString(9)};
				//returning as an array
				return employee;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//returning null if not found
		return null;
		
	}
	
	public void eventInfo(int eventID) {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM TRMS_EVENTS WHERE EVENT_ID="+eventID;
		
		
		}
	public double pendingAwards(int empID) {
		Connection conn = cf.getConnection();
			String sql = "SELECT EVENT_COST FROM TRMS_EVENT " +
						"LEFT JOIN TRMS_REIMBURST\r\n" + 
						"ON TRMS_EVENT.EVENT_ID=TRMS_REIMBURST.EVENT_ID\n"
						+ "WHERE EMPLOYEE_ID="+empID;
		Statement stmt;
		double pendingAwards = 0;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				pendingAwards = pendingAwards + rs.getDouble("EVENT_COST");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pendingAwards;
	}
}
