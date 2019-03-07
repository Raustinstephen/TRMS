package com.revature.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	private static ConnFactory cf= new ConnFactory();
	private ConnFactory() {
		super();
	}
	public static synchronized ConnFactory getInstance() {
		if(cf==null) {
			cf=new ConnFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn= null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn= DriverManager.getConnection
("jdbc:oracle:thin:@pega21119.c5uhkt5fsphe.us-east-2.rds.amazonaws.com:1521:ORCL",
					"RichardStephen",
					"Revature");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
