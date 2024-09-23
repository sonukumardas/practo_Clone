package com.sonu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sonu.db.MySqlDbcon;
import com.sonu.doctor.Doctor;

public class DoctorDao {

	// method 1
	public static boolean isDoctorExist(Long phoneNumber) {
		boolean flag = false;
		Connection connection = null;

		try {
			connection = MySqlDbcon.getDbConnection();
			PreparedStatement statement = connection.prepareStatement(QueryConstants.DOCTOR_PHONE_NUMBER_EXIST_QUERY);
			statement.setLong(1, phoneNumber);
			ResultSet resultSet = statement.executeQuery();
			flag = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return flag;

	}

	// method 2

	public static int saveDoctor(Doctor doctor) {
		int result = 0;
		Connection connection = null;

		try {
			connection = MySqlDbcon.getDbConnection();
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(QueryConstants.DOCTOR_INSERT_QUERY);

			statement.setString(1, doctor.getFullName());
			statement.setLong(2, doctor.getPhoneNumber());
			statement.setString(3, doctor.getPassword());
			statement.setString(4, doctor.getGender());
			statement.setInt(5, doctor.getAge());
			statement.setString(6, doctor.getSpecialist());

			result = statement.executeUpdate();
			if (result > 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return result;
	}

	// method 3
	public static boolean doctorSignin(Long phoneNumber, String password) {
		boolean flag = false;
		Connection connection = null;

		try {
			connection = MySqlDbcon.getDbConnection();
			PreparedStatement statement = connection.prepareStatement(QueryConstants.DOCTOR_LOGIN_QUERY);
			statement.setLong(1, phoneNumber);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			flag = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return flag;

	}

	// show doctors
	public static List<Doctor> showAllDoctors() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		Connection connection = null;
		try {
			connection = MySqlDbcon.getDbConnection();
			PreparedStatement statement = connection.prepareStatement(QueryConstants.Doctor_Select_Query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Doctor doctor = new Doctor(resultSet.getString(1), resultSet.getLong(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6));
				doctors.add(doctor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return doctors;
	}

	// delete doctor
	public static int doctorDelete(long phone) {
		int result = 0;
		;
		Connection connection = null;

		try {
			connection = MySqlDbcon.getDbConnection();
			PreparedStatement statement = connection.prepareStatement(QueryConstants.Doctor_Delete_Query);
			statement.setLong(1, phone);
			result = statement.executeUpdate();
			if (result > 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;

	}

	// finding Doctor
	public static Doctor findDoctor(long phone) {
		Doctor doctor = null;
		Connection connection = null;

		try {
			connection = MySqlDbcon.getDbConnection();
			PreparedStatement statement = connection.prepareStatement(QueryConstants.DOCTOR_PHONE_NUMBER_EXIST_QUERY);
			statement.setLong(1, phone);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				doctor = new Doctor(resultset.getString(1), resultset.getLong(2), resultset.getString(3),
						resultset.getString(4), resultset.getInt(5), resultset.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return doctor;
	}

	public static int updateDoctor(long phone, Doctor newdoctor) {
		int result = 0;

		Connection connection = null;
		try {
			connection = MySqlDbcon.getDbConnection();
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(QueryConstants.Doctor_Update_Query);
			statement.setString(1, newdoctor.getFullName());
			statement.setString(2, newdoctor.getPassword());
			statement.setString(3, newdoctor.getGender());
			statement.setInt(4, newdoctor.getAge());
			statement.setString(5, newdoctor.getSpecialist());
			statement.setLong(6, newdoctor.getPhoneNumber());
			result = statement.executeUpdate();
			if (result > 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

}
