package com.sonu.admin;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AdminLogInSuccess extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("adminName");
				
		String finalResponse="<h1 style='color:green'>Hey "+name+", You LoggedIn Successfully</h1>";
		finalResponse+="<a href='ShowPatients'>Show Registered Patients</a> || ";
		finalResponse+="<a href='ShowDoctors'>Show Registered Doctors</a>";
		
		
		finalResponse+="<br><br><br><br><br><br><br>";
		finalResponse+="<a href='AdminLogOut'>LogOut</a>";
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(finalResponse);
		
	}

}
