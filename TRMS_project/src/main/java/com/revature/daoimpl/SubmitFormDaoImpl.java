package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.beans.ReimburstReq;
import com.revature.util.ConnFactory;

public class SubmitFormDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();
	public void submitForm(ReimburstReq req, int EMP_ID) {
		Connection conn = cf.getConnection();
		String sql = "{ call INSERT_REIMB_REQ(?,?,?,?,?,?,?,?,?)";
		CallableStatement call;
		try {
			call = conn.prepareCall(sql);
		
		call.setInt(1, EMP_ID);
		call.setString(2, req.getJustification());
		call.setString(3, req.getHoursMissed());
		call.setString(4, req.getEventName());
		call.setString(5, req.getEventDesc());
		call.setString(6, req.getAddress()+req.getCity() + ", " + req.getState());
		call.setString(7, "2019/03/09 9:00:00");
		call.setString(8, req.getEventCost());
		call.setString(9, req.getGradeFormat());
		call.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
