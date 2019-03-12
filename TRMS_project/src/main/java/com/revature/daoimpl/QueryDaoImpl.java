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
	String sql = "SELECT * FROM TRMS_EMPLOYEE WHERE EMPLOYEE_ID="+empID;
	Statement stmt;
	try {
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);
			String reportsTo = rs.getString(8);
			String totalAwarded = rs.getString(9);
			
			
			
			//first nested statement for info from TRMS_REIMBURST
			sql = "SELECT * FROM TRMS_REIMBURST WHERE EMPLOYEE_ID="+empID;
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int eventID = rs.getInt(3);
					String justification = rs.getString(4);
					int reimbStatus = rs.getInt(5);
					double hoursMissed = rs.getDouble(6);
					String nextAuthorize = rs.getString(7);
					String timeStamp = rs.getString(8);
					
			//second nested statement for info from TRMS_EVENT
					sql = "SELECT * FROM TRMS_EVENT WHERE EVENT_ID="+eventID;
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						//all the items from TRMS_EVENT that we need
						String eventName = rs.getString(2);
						String eventDesc = rs.getString(3);
						String eventLoc = rs.getString(4);
						String eventTime = rs.getString(5);
						double eventCost = rs.getDouble(6);
						String gradeFormat = rs.getString(7);
						//eventType still needs to be implemented in SQL
						String eventType = rs.getString(8);
						
						//putting everything in the monster bean
						ReimbInfo info = new ReimbInfo(eventName, eventType, eventDesc, eventLoc, eventTime,
								eventCost, gradeFormat, justification, reimbStatus, hoursMissed,
								nextAuthorize, timeStamp, firstName, lastName, email, reportsTo,
								totalAwarded);
						ri.add(info);
						
					}
					
				}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ri;	
	}
	
	public void eventInfo(int eventID) {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM TRMS_EVENTS WHERE EVENT_ID="+eventID;
		
		
		}
}
