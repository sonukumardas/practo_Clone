package com.sonu.doctor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.sonu.dao.DoctorDao;

public class DoctorSignupProcess extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String finalResponse = "";

		String fullName = request.getParameter("n1");
		Long phoneNumber = Long.parseLong(request.getParameter("n2"));
		String password = request.getParameter("n3");
		String gender = request.getParameter("n5");
		Integer age = Integer.parseInt(request.getParameter("n6"));
		String specialist = request.getParameter("n7");

		Doctor doctor = new Doctor(fullName, phoneNumber, password, gender, age, specialist);

		System.out.println("doctor= " + doctor);

		if (DoctorDao.isDoctorExist(phoneNumber)) {
			response.sendRedirect("DoctorSignupError");
			
			
		} else {
			DoctorDao.saveDoctor(doctor);
			RequestDispatcher rd = request.getRequestDispatcher("DoctorSignupSuccess");
			request.setAttribute("key1", doctor);
			rd.forward(request, response);

		}

		
	}

}
