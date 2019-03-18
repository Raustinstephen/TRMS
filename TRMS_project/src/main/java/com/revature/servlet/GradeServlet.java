package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Grade;
import com.revature.daoimpl.UpdateDaoImpl;


public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GradeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateDaoImpl udi = new UpdateDaoImpl();
		ObjectMapper om = new ObjectMapper();
		Grade g = om.readValue(request.getInputStream(),Grade.class);
		udi.updateGrade(g);
	}

}
