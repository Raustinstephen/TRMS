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

public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SubmitServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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
			sfdi.submitForm(req, (Integer) sess.getAttribute("EMP_ID"));
			}
	}
}
