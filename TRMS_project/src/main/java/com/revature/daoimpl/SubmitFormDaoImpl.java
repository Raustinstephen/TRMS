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
		Connection conn = cf.getConnection();
		String sql = "{ call INSERT_REIMB_REQ(?,?,?,?,?,?,?,?,?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
			Parsing parse = new Parsing();
		double cost = parse.parsingDouble(req.getEventCost());
		double hours = parse.parsingDouble(req.getHoursMissed());
		int eventType = parse.parsingInt(req.getEventType());
		int gradeForm = parse.parsingInt(req.getGradeFormat());
		System.out.println(eventType + " === " + gradeForm);
		call.setInt(1, EMP_ID);
		call.setString(2, req.getJustification());
		call.setDouble(3, hours);
		call.setString(4, req.getEventName());
		call.setString(5, req.getEventDesc());
		call.setString(6, req.getAddress()+req.getCity() + ", " + req.getState());
		call.setString(7, "2019/03/09 9:00:00");
		call.setDouble(8, cost);
		call.setInt(9, gradeForm);
		call.setInt(10, eventType);
		call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
