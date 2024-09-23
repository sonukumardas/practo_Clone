package com.sonu.admin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminLogInError extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String finalResponse="<h1 style='color:red'>Oops!! Invalid Pass Code or User Id</h1>";
		finalResponse+="<a href='adminlogin.html'>Try Again</a> | <a href='index.html'>Home</a>";
		
		out.println(finalResponse);
	}

}