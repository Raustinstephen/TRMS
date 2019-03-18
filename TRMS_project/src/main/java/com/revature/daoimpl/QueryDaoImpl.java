package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public ArrayList<ReimbInfo> nextApprove(int empID) {
		Connection conn = cf.getConnection();
		ArrayList<ReimbInfo> ri = new ArrayList<ReimbInfo>();
				PreparedStatement ps;
				try {
					String sql = 	"SELECT * "
		+							" FROM ((TRMS_REIMBURST"
		+							" INNER JOIN TRMS_EVENT ON TRMS_REIMBURST.EVENT_ID = TRMS_EVENT.EVENT_ID)"
		+							" INNER JOIN TRMS_EMPLOYEE ON TRMS_REIMBURST.EMPLOYEE_ID = TRMS_EMPLOYEE.EMP_ID)"
		+							" WHERE TRMS_REIMBURST.NEXT_AUTHORIZE_ID = "+empID;
							
						ps = conn.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							ReimbInfo rei = new ReimbInfo(
									rs.getInt("REIMBURST_ID"),
									rs.getString("R_TIMESTAMP"),
									rs.getString("FIRST_NAME")+" "+rs.getString("LAST_NAME"),
									rs.getString("TITLE"),
									rs.getInt("DEPT"),
									rs.getString("EVENT_NAME"),
									rs.getInt("EVENT_TYPE"),
									rs.getInt("GRADE_FORMAT"),
									rs.getString("EVENT_LOCATION"),
									rs.getString("EVENT_DATE"),
									rs.getString("GRADE"),
									rs.getDouble("EVENT_COST"),
									rs.getDouble("EST_REIMB"),
									rs.getDouble("WORKHOURS_MISSED"),
									rs.getString("JUSTIFICATION"));
									ri.add(rei);
						}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
		return ri;	
	}
}
