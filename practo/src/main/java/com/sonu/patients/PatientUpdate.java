package com.sonu.patients;

import java.io.IOException;

import com.sonu.dao.PatientDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class PatientUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String fullname = request.getParameter("n1");
		Long phoneNumber = Long.parseLong(request.getParameter("n2"));
		String password = request.getParameter("n3");
		String gender = request.getParameter("n4");
		int age = Integer.parseInt(request.getParameter("n5"));
		String dateofAppointment = request.getParameter("n6");
		String specialist = request.getParameter("n7");
		Patient newpatient = new Patient();
		newpatient.setFullName(fullname);
		newpatient.setPhoneNumber(phoneNumber);
		newpatient.setPassword(password);
		newpatient.setGender(gender);
		newpatient.setAge(age);
		newpatient.setDateofAppointment(dateofAppointment);
		newpatient.setSpecialist(specialist);
		int result = PatientDao.updatePatient(phoneNumber, newpatient);
		if (result > 0) {
			response.sendRedirect("ShowPatients");

		}
		
	}

}
