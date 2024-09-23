package com.sonu.doctor;

import java.io.IOException;

import com.sonu.dao.DoctorDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoctorDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long phonenumber = Long.parseLong(request.getParameter("phone"));
		int result = DoctorDao.doctorDelete(phonenumber);
		if (result > 0) {
			response.sendRedirect("ShowDoctors");

		}

	}
}