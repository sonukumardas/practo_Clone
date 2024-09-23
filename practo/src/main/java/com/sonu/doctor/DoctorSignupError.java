package com.sonu.doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DoctorSignupError extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String finalResponse = "<h1 style = 'color:red'>Phone number is already exist,please try with other number</h1>";
		finalResponse += "<a href='doctorSignup.html'>Try again</a>";
	
		out.print(finalResponse);
		
	}

}
