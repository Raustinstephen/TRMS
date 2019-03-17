package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimpl.LoginDaoImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: login doGet").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		LoginDaoImpl ldi = new LoginDaoImpl();
		int id = 0;
		try {
			id = ldi.login(request.getParameter("username"),request.getParameter("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(id != 0) {
			sess.setAttribute("EMP_ID", id);
	        request.getRequestDispatcher("employeeDash.html").forward(request, response); 
		}else {
			response.sendRedirect("login.html");
		} 
	}

}
