package com.sonu.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.sonu.dao.PatientDao;
import com.sonu.patients.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ShowPatients extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("adminName");
		out.print("<p align='right'> Welcome Mr: " + name + " </p> ");
		out.print("<h2> Registered patients are :</h2>");
		List<Patient> patients = PatientDao.findAllPatients();

		out.print("<tr>");
		out.print("<table align='center' cellspacing='5px' cellpadding='5px' border='2px'> ");
		out.print("<tr>");
		out.print("<th>Full Name</th>");
		out.print("<th>Phone Name</th>");
		out.print("<th>Password</th>");
		out.print("<th>Gender</th>");
		out.print("<th>Age</th>");
		out.print("<th>Date of Appointment</th>");
		out.print("<th>Specialist</th>");
		out.print("</tr>");

		for (Patient patient : patients) {
			out.print("<tr>");
			out.print("<td>" + patient.getFullName() + "</td>");
			out.print("<td>" + patient.getPhoneNumber() + "</td>");
			out.print("<td>" + patient.getPassword() + "</td>");
			out.print("<td>" + patient.getGender() + "</td>");
			out.print("<td>" + patient.getAge() + "</td>");
			out.print("<td>" + patient.getDateofAppointment() + "</td>");
			out.print("<td>" + patient.getSpecialist() + "</td>");
			out.print("<td>" + "<a href='editPatient?phone="+ patient.getPhoneNumber()+"'>Edit</a>"+ "</td>");
			out.print("<td>" + "<a href='deletePatient?phone="+ patient.getPhoneNumber()+"'>Delete</a>" + "</td>");
			out.print("</tr>");
		}

		out.print("</table>");

		out.print("<a href ='index.html'>Logout</a>");
	}

}
