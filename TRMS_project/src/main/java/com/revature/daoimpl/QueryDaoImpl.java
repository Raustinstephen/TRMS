package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.ReimbInfo;
import com.revature.util.ConnFactory;

public class QueryDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public ArrayList<ReimbInfo> reimbInfo(int empID) {
	Connection conn = cf.getConnection();
	ArrayList<ReimbInfo> ri = new ArrayList<ReimbInfo>();
	
			String employee[] = empInfo(empID);
			String firstName = employee[0];
			String lastName = employee[1];
			String email = employee[2];
			String reportsTo = employee[3];
			String totalAwarded = employee[4];
		
			Statement stmt;
			try {
				String sql = "SELECT * FROM TRMS_EVENT " +
							"LEFT JOIN TRMS_REIMBURST\r\n" + 
							"ON TRMS_EVENT.EVENT_ID=TRMS_REIMBURST.EVENT_ID\n"
							+ "WHERE EMPLOYEE_ID="+empID;
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						//all the items from TRMS_EVENT and TRMS_REIMBURST that we need
						String eventName = rs.getString(2);
						String eventDesc = rs.getString(3);
						String eventLoc = rs.getString(4);
						String eventTime = rs.getString(5);
						double eventCost = rs.getDouble(6);
						String gradeFormat = rs.getString(7);
						String eventType = rs.getString(8);
						int reimbID = rs.getInt(9);
						int eventID = rs.getInt(11);
						String justification = rs.getString(12);
						int reimbStatus = rs.getInt(13);
						double hoursMissed = rs.getDouble(14);
						String nextAuthorize = rs.getString(15);
						String timeStamp = rs.getString(16);
						
						//putting everything in the monster bean
						ReimbInfo info = new ReimbInfo(eventName, eventType, eventDesc, eventLoc, eventTime,
								eventCost, gradeFormat, justification, reimbID, reimbStatus, hoursMissed,
								nextAuthorize, timeStamp, firstName, lastName, email, reportsTo,
								totalAwarded);
						ri.add(info);
						
					}
//				}
		}
		
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	return ri;	
	}
	
	
	public ArrayList<ReimbInfo> nextApprove(int empID) {
		Connection conn = cf.getConnection();
		ArrayList<ReimbInfo> ri = new ArrayList<ReimbInfo>();
		
				String employee[] = empInfo(empID);
				String firstName = employee[0];
				String lastName = employee[1];
				String email = employee[2];
				String reportsTo = employee[3];
				String totalAwarded = employee[4];
			
				Statement stmt;
				try {
					String sql = "SELECT * FROM TRMS_REIMBURST " +
								"LEFT JOIN TRMS_EVENT\r\n" + 
								"ON TRMS_REIMBURST.EVENT_ID=TRMS_EVENT.EVENT_ID\n"
								+ "WHERE NEXT_AUTHORIZE_ID="+empID;
						stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							//all the items from TRMS_EVENT and TRMS_REIMBURST that we need
							int queryEmpID = rs.getInt(2);
							String eventName = rs.getString(11);
							String eventDesc = rs.getString(12);
							String eventLoc = rs.getString(13);
							String eventTime = rs.getString(14);
							double eventCost = rs.getDouble(15);
							String gradeFormat = rs.getString(16);
							String eventType = rs.getString(17);
							int reimbID = rs.getInt(1);
							int eventID = rs.getInt(3);
							String justification = rs.getString(4);
							int reimbStatus = rs.getInt(5);
							double hoursMissed = rs.getDouble(6);
							String nextAuthorize = rs.getString(7);
							String timeStamp = rs.getString(8);
							
							//putting everything in the monster bean
							ReimbInfo info = new ReimbInfo(eventName, eventType, eventDesc, eventLoc, eventTime,
									eventCost, gradeFormat, justification, reimbID, reimbStatus, hoursMissed,
									nextAuthorize, timeStamp, firstName, lastName, email, reportsTo,
									totalAwarded);
							ri.add(info);
							
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
}
