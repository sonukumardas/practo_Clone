package com.sonu.doctor;

import java.io.IOException;

import com.sonu.dao.DoctorDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DoctorUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String fullname = request.getParameter("n1");
		Long phoneNumber = Long.parseLong(request.getParameter("n2"));
		String password = request.getParameter("n3");
		String gender = request.getParameter("n4");
		int age = Integer.parseInt(request.getParameter("n5"));
		String specialist = request.getParameter("n6");
		Doctor newdoctor = new Doctor();
		newdoctor.setFullName(fullname);
		newdoctor.setPhoneNumber(phoneNumber);
		newdoctor.setPassword(password);
		newdoctor.setGender(gender);
		newdoctor.setAge(age);
		newdoctor.setSpecialist(specialist);
		int result = DoctorDao.updateDoctor(phoneNumber, newdoctor);
		if (result > 0) {
			response.sendRedirect("ShowDoctors");
		}
	}

}
