package com.sonu.patients;

import java.io.IOException;

import com.sonu.dao.PatientDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class PatientSignupProcess extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String fullName = request.getParameter("n1");
		Long phoneNumber = Long.parseLong(request.getParameter("n2"));
		String password = request.getParameter("n3");
		String gender = request.getParameter("n5");
		Integer age = Integer.parseInt(request.getParameter("n6"));
		String dateofAppointment = request.getParameter("n7");
		String specialist = request.getParameter("n8");
		
		Patient patient = new Patient(fullName, phoneNumber, password, gender, age, dateofAppointment, specialist);
		
		System.out.println("patient= "+patient);
		
		if(PatientDao.isPatientExist(phoneNumber)) {
			response.sendRedirect("PatientSignupError");
			
		} else {
			PatientDao.savePatient(patient);
			RequestDispatcher rd = request.getRequestDispatcher("PatientSignupSuccess");
			request.setAttribute("k1", patient);
			rd.forward(request, response);
		}
		
		
	}

}
