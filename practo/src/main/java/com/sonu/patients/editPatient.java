package com.sonu.patients;

import java.io.IOException;
import java.io.PrintWriter;

import com.sonu.dao.PatientDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class editPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long phoneNumber = Long.parseLong(request.getParameter("phone"));
		Patient patient = PatientDao.findPatient(phoneNumber);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h2>Edit Patient Details</h2>");
		out.print("<form action='PatientUpdate'>");
		out.print("Fullname:<input type='text' name='n1' value='" + patient.getFullName() + "'> <br>");
		out.print("PhoneNumber:<input type='hidden' name='n2' value='" + patient.getPhoneNumber() + "'> <br>");
		out.print("password:<input type='text' name='n3' value='" + patient.getPassword() + "'> <br>");
		out.print("Gender:<input type='text' name='n4' value='" + patient.getGender() + "'> <br>");
		out.print("Age:<input type='number' name='n5' value='" + patient.getAge() + "'> <br>");
		out.print(
				"DateofAppointment:<input type='text' name='n6' value='" + patient.getDateofAppointment() + "'> <br>");
		out.print("Specialist:<select type='text' name='n7' value='" + patient.getSpecialist()
				+ "'><option value=\"Select Course\">Select Specialist</option>\r\n"
				+ "						<option value='Dentist'>Dentist</option>\r\n"
				+ "						<option value='ENT'>ENT</option>\r\n"
				+ "						<option value='cardiologist'>Cardiologist</option>\r\n"
				+ "						<option value='Psychiatrist'>Psychiatrist</option>\r\n"
				+ "						<option value='Pediatricians'>Pediatricians</option> </select> <br>");
		out.print("<input type='submit' value='update'> ");
		out.print("</form>");	
	}

}
