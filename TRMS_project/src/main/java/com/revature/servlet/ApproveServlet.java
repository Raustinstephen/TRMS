package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Approve;
import com.revature.daoimpl.UpdateDaoImpl;

public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ApproveServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		ObjectMapper om = new ObjectMapper();
		Approve approveUpdate = om.readValue(request.getInputStream(),Approve.class);
		UpdateDaoImpl udi = new UpdateDaoImpl();
		udi.approve(approveUpdate,(Integer) sess.getAttribute("EMP_ID"));
	}

}
