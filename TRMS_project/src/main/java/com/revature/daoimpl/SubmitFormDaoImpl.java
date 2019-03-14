package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.beans.ReimburstReq;
import com.revature.util.ConnFactory;
import com.revature.util.Parsing;

public class SubmitFormDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();
	public void submitForm(ReimburstReq req, int EMP_ID) {
		QueryDaoImpl qdi = new QueryDaoImpl();
		Connection conn = cf.getConnection();
		String sql = "{ call INSERT_REIMB_REQ(?,?,?,?,?,?,?,?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			Parsing parse = new Parsing();
		double cost = parse.parsingDouble(req.getEventCost());
		String[] employee = qdi.empInfo(EMP_ID);
		String totalAwardedStr = employee[4];
		double hours = parse.parsingDouble(req.getHoursMissed());
		int eventType = parse.parsingInt(req.getEventType());
		double totalAwarded = Double.parseDouble(totalAwardedStr);
		double toBeAwarded=0;
		double pendingAward = qdi.pendingAwards(EMP_ID);
		if (eventType==1) {
			toBeAwarded = cost*0.8;
		}
		else if (eventType==2) {
			toBeAwarded = cost*0.6;
		}
		else if (eventType==3) {
			toBeAwarded = cost*0.75;
		}
		else if (eventType==4) {
			toBeAwarded = cost;
		}
		else if (eventType==5) {
			toBeAwarded = cost*0.9;
		}
		else if (eventType==6) {
			toBeAwarded = cost*0.3;
		}
		if (toBeAwarded + totalAwarded + pendingAward>=1000) {
			if (1000 - totalAwarded - pendingAward < 0) {
			toBeAwarded=0;
			}
			else {
				toBeAwarded = 1000 - totalAwarded - pendingAward;
			}
		}
		
		
		
		
		int gradeForm = parse.parsingInt(req.getGradeFormat());
		call.setInt(1, EMP_ID);
		//call.setString(2, req.getJustification());
		call.setDouble(2, hours);
		call.setString(3, req.getEventName());
		call.setString(4, req.getEventDesc());
		call.setString(5, req.getAddress()+", "+req.getCity() + ", " + req.getState());
		call.setString(6, "2019/03/21 9:00:00");
		call.setDouble(7, toBeAwarded);
		call.setInt(8, gradeForm);
		call.setInt(9, eventType);
		call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
