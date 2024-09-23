package com.sonu.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminLogInProcedure extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("n1");
		String passCode = request.getParameter("n2");
		
		if(userId.equalsIgnoreCase("admin") && passCode.equalsIgnoreCase("nimda")) {
			HttpSession session = request.getSession(true);
			session.setAttribute("adminName", "Dr Das");
			response.sendRedirect("AdminLogInSuccess");
		}
		else {
			response.sendRedirect("AdminLogInError");
		}
	}

}