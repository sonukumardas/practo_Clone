package com.sonu.patients;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class PatientSignupSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Patient patient = (Patient) request.getAttribute("k1");
		
		String finalResponse ="<h1 style='color:green'>Hey  "+patient.getFullName()+", your registration done sucessfully</h1>";
		finalResponse+="<a href='index.html'>Home</a> | <a href='login.html'>Login</a>"; 
	
		out.print(finalResponse);
		
	}

}
