package com.sonu.patients;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class PatientSignupError extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String finalResponse = "<h1 style = 'color:red'>Phone number is already exist,please try with other number</h1>";
		finalResponse+="<a href='reg.html'>Try again</a>";
	
		out.print(finalResponse);
		
	}

}
