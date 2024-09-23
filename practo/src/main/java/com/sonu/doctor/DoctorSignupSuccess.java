package com.sonu.doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DoctorSignupSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Doctor doctor = (Doctor) request.getAttribute("key1");
		
		String finalResponse = "<h1 style='color:green'>Hey  " + doctor.getFullName() + ", your registration done sucessfully</h1>";
		finalResponse += "<a href='index.html'>Home</a> | <a href='doctorlogin.html'>Doctor Login</a>";
		out.print(finalResponse);
	
	
	}

}
