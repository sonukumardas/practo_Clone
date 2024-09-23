package com.sonu.doctor;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DoctorLoginError extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String finalResponse = "";
		finalResponse = "<h1 style='color:red'>Invalid phone number or password</h1>";
		finalResponse += "<a href='login.html'>Try again</a> | <a href='reg.html'>New user</a <a href='index.html>Home</a> |";
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(finalResponse);
	
	}

}
