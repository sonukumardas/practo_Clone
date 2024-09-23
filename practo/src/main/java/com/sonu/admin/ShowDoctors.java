package com.sonu.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.sonu.dao.DoctorDao;
import com.sonu.doctor.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ShowDoctors extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("adminName");
		List<Doctor> showAllDoctors = DoctorDao.showAllDoctors();
		out.print("<p align='right'>Welcome" + name + "</p>");
		out.print("<h1>Registered Doctors are :</h1>");
		out.print("<table align='center' border='2px' cellpadding='5px' cellspacing='5px'>");
		out.print("<tr>"
				+ "<th>fullname</th> <th>PhoneNumber</th> <th>Password</th> <th>Gender</th> <th>Age</th> <th>specialist</th>");
		for (Doctor doctor : showAllDoctors) {
			out.print("<tr>");
			out.print("<td>" + doctor.getFullName() + "</td>");
			out.print("<td>" + doctor.getPhoneNumber() + "</td>");
			out.print("<td>" + doctor.getPassword() + "</td>");
			out.print("<td>" + doctor.getGender() + "</td>");
			out.print("<td>" + doctor.getAge() + "</td>");
			out.print("<td>" + doctor.getSpecialist() + "</td>");
			out.print("<td><a href='DoctorEdit?phone=" + doctor.getPhoneNumber() + "' >Edit</a></td>");
			out.print("<td><a href='DoctorDelete?phone=" + doctor.getPhoneNumber() + "' >Delete</a></td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("<a href='AdminLoginSuccess'>Back</a>");
	}

}
