package com.sonu.doctor;

import java.io.IOException;

import com.sonu.dao.DoctorDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoctorLoginProcess extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long phoneNumber = Long.parseLong(request.getParameter("n1"));
		String password = request.getParameter("n2");

		Doctor doctor = new Doctor();
		doctor.setPhoneNumber(phoneNumber);
		doctor.setPassword(password);

		System.out.println("phone number= " + phoneNumber + ",password=" + password);

		if (DoctorDao.doctorSignin(phoneNumber, password)) {
			// RequestDispatcher rd = request.getRequestDispatcher("DoctorLoginSuccess");
			// request.setAttribute("key1", phoneNumber);
			// rd.forward(request, response);

			HttpSession session = request.getSession();
			session.setAttribute("key1", phoneNumber);
			response.sendRedirect("DoctorLoginSuccess");

		} else {
			response.sendRedirect("DoctorLoginError");

		}

	}

}
