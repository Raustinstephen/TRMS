package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ReimburstReq;
import com.revature.daoimpl.SubmitFormDaoImpl;
import com.revature.util.Parsing;

/**
 * Servlet implementation class SubmitServlet
 */
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
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
		HttpSession sess = request.getSession();
		ObjectMapper mapper = new ObjectMapper();
		ReimburstReq req = null;
		try{
			req=mapper.readValue(request.getInputStream(),ReimburstReq.class);
		}catch(JsonParseException e) {
			System.out.println(request.getInputStream());
		}
		if(req == null) {
			System.out.println("nooo");
		}else {
			
			SubmitFormDaoImpl sfdi = new SubmitFormDaoImpl();
			System.out.println(req.toString());
			Parsing parse = new Parsing();
			System.out.println("EMP ID: " + sess.getAttribute("EMP_ID"));
			
			//int empID= parse.parsingInt(sess.getAttribute);
			sfdi.submitForm(req, (Integer) sess.getAttribute("EMP_ID"));
			}
		 response.setContentType("text/plain");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write("wahooooo");
	}

}
