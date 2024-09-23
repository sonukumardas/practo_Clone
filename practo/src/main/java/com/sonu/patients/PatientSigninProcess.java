package com.sonu.patients;

import java.io.IOException;

import com.sonu.dao.PatientDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PatientSigninProcess extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long phoneNumber = Long.parseLong(request.getParameter("n1"));
		String password = request.getParameter("n2");

		Patient patient = new Patient();
		patient.setPhoneNumber(phoneNumber);
		patient.setPassword(password);

		System.out.println("phone number= " + phoneNumber + ",password=" + password);

		if (PatientDao.patientSignin(phoneNumber, password)) {

		//	RequestDispatcher rd = request.getRequestDispatcher("PatientSigninSuccess");
		//	rd.forward(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("k1", phoneNumber);
			response.sendRedirect("PatientSigninSuccess");

		} else {
			response.sendRedirect("PatientSigninError");

		}

	}

}
