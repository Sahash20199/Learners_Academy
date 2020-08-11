package com.la.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Username = request.getParameter("name");
		String Password = request.getParameter("password");
		
		RequestDispatcher dispatcher = null;
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		if(Username.equals("admin") && (Password.equals("password"))) {
			HttpSession session = request.getSession();
			session.setAttribute("user", Username);
			response.sendRedirect("Dashboard.jsp");
		}
		else {
			writer.println("<h3 style='color:black' class='form-signin'>Invalid Login Credentials.. Try Again..</h3>");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
		}
	
	}

}
