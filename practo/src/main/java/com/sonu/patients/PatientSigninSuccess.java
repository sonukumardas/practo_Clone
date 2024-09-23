package com.sonu.patients;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class PatientSigninSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Long phoneNumber = (Long) session.getAttribute("k1");
		String finalResponse = "";
		finalResponse = "<h1 style = 'color:blue'>Hey "+phoneNumber+", your logged in sucessful</h1>";
		finalResponse += "<a href='PatientLogOut'>Logout</a>";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(finalResponse);
		
	
	}

}
