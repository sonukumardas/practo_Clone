package com.sonu.doctor;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class DoctorLoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Long phoneNumber = (Long) session.getAttribute("key1");
		String finalResponse = "";
		finalResponse = "<h1 style = 'color:blue'>Hey " + phoneNumber + ", your login is sucessful</h1>";
		finalResponse += "<a href='DoctorLogout'>Logout</a>";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(finalResponse);
		
		
	}

}
