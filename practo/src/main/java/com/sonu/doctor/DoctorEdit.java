package com.sonu.doctor;

import java.io.IOException;
import java.io.PrintWriter;

import com.sonu.dao.DoctorDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DoctorEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Long phoneNumber = Long.parseLong(request.getParameter("phone"));
		Doctor doctor = DoctorDao.findDoctor(phoneNumber);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h2>Edit Doctor Details</h2>");
		out.print("<form action='DoctorUpdate'>");
		out.print("Fullname:<input type='text' name='n1' value='" + doctor.getFullName() + "'> <br>");
		out.print("PhoneNumbet:<input type='hidden' name='n2' value='" + doctor.getPhoneNumber() + "'> <br>");
		out.print("password:<input type='text' name='n3' value='" + doctor.getPassword() + "'> <br>");
		out.print("Gender:<input type='text' name='n4' value='" + doctor.getGender() + "'> <br>");
		out.print("Age:<input type='number' name='n5' value='" + doctor.getAge() + "'> <br>");
		out.print("Specialist:<select type='text' name='n6' value='" + doctor.getSpecialist()
				+ "'><option value='Select Course'>Select Specialist</option>\r\n"
				+ "						<option value='Dentist'>Dentist</option>\r\n"
				+ "						<option value='ENT'>ENT</option>\r\n"
				+ "						<option value='cardiologist'>Cardiologist</option>\r\n"
				+ "						<option value='Psychiatrist'>Psychiatrist</option>\r\n"
				+ "						<option value='Pediatricians'>Pediatricians</option> </select> <br>");
		out.print("<input type='submit' value='update'> ");
		out.print("</form>");
		
	}

}
