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
		String sql = "{ call INSERT_REIMB_REQ(?,?,?,?,?,?,?,?,?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			Parsing parse = new Parsing();
			Double toBeAwarded;
			int eventType = parse.parsingInt(req.getEventType());
			double cost = parse.parsingDouble(req.getEventCost());
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
			}else {
				//nothing
			}
		call.setInt(1, EMP_ID);
		call.setString(2,req.getEventName());
		call.setInt(3,parse.parsingInt(req.getEventType()));
		call.setInt(4, parse.parsingInt(req.getGradeFormat()));
		call.setString(5, req.getDate());
		call.setString(6, req.getAddress()+", "+req.getCity() + ", " + req.getState());
		call.setDouble(7, parse.parsingDouble(req.getEventCost()));
		call.setDouble(8, parse.parsingDouble(req.getHoursMissed()));
		call.setString(9, req.getEventJust());
		call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
