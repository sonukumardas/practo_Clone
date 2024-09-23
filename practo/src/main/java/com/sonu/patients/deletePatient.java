package com.sonu.patients;

import java.io.IOException;

import com.sonu.dao.PatientDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class deletePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long phonenumber = Long.parseLong(request.getParameter("phone"));
		int result = PatientDao.patientDelete(phonenumber);
		if (result > 0) {
			response.sendRedirect("ShowPatients");

		}

	}
}
