package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ReimbInfo;
import com.revature.daoimpl.QueryDaoImpl;

/**
 * Servlet implementation class ViewRequestServlet
 */
public class ViewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryDaoImpl qdi = new QueryDaoImpl();
		HttpSession sess = request.getSession();
		ArrayList<ReimbInfo> ri = qdi.nextApprove((Integer)sess.getAttribute("EMP_ID"));
		ObjectMapper om = new ObjectMapper();
		response.setContentType("application/json");
		om.writeValue(response.getOutputStream(), ri);
	}

}
