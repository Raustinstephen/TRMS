package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Deny;
import com.revature.daoimpl.UpdateDaoImpl;


public class DenyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DenyServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		Deny denyUpdate = om.readValue(request.getInputStream(),Deny.class);
		UpdateDaoImpl udi = new UpdateDaoImpl();
		udi.deny(denyUpdate);
	}

}
