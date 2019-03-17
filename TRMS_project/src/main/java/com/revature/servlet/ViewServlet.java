package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ReimView;
import com.revature.daoimpl.QueryDaoImpl;


public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryDaoImpl qdi = new QueryDaoImpl();
		HttpSession sess = request.getSession();
		ArrayList<ReimView> ri = qdi.getReqInfo((Integer)sess.getAttribute("EMP_ID"));
		ObjectMapper om = new ObjectMapper();
		response.setContentType("application/json");
		om.writeValue(response.getOutputStream(), ri);
	}
}
