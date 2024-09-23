package com.sonu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sonu.db.MySqlDbcon;
import com.sonu.patients.Patient;

public class PatientDao {

//method 1
	public static boolean isPatientExist(Long phoneNumber) {
		boolean flag = false;
		Connection connection = null;

		try {
			connection = MySqlDbcon.getDbConnection();
			PreparedStatement statement = connection.prepareStatement(QueryConstants.PATIENT_PHONE_NUMBER_EXIST_QUERY);
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

	public static int savePatient(Patient patient) {
		int result = 0;
		Connection connection = null;

		try {
			connection = MySqlDbcon.getDbConnection();
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(QueryConstants.PATIENT_INSERT_QUERY);

			statement.setString(1, patient.getFullName());
			statement.setLong(2, patient.getPhoneNumber());
			statement.setString(3, patient.getPassword());
			statement.setString(4, patient.getGender());
			statement.setInt(5, patient.getAge());
			statement.setString(6, patient.getDateofAppointment());
			statement.setString(7, patient.getSpecialist());

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
	public static boolean patientSignin(Long phoneNumber, String password) {
		boolean flag = false;
		Connection connection = null;

		try {
			connection = MySqlDbcon.getDbConnection();
			PreparedStatement statement = connection.prepareStatement(QueryConstants.PATIENT_LOGIN_QUERY);
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

	// method 4
	public static List<Patient> findAllPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		Connection connection = null;

		try {
			connection = MySqlDbcon.getDbConnection();
			PreparedStatement statement = connection.prepareStatement(QueryConstants.PATIENT_SELECT_QUERY);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Patient patient = new Patient(resultSet.getString(1), resultSet.getLong(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7));
				patients.add(patient);
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

		return patients;

	}
	
	// patient Delete

		public static int patientDelete(long phone) {
			int result = 0;
			;
			Connection connection = null;

			try {
				connection =  MySqlDbcon.getDbConnection();
				PreparedStatement statement = connection.prepareStatement(QueryConstants.PATIENT_DELETE_QUERY);
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

		// finding Patient

		public static Patient findPatient(long phone) {
			Patient patient = null;
			Connection connection = null;

			try {
				connection =  MySqlDbcon.getDbConnection();
				PreparedStatement statement = connection
						.prepareStatement(QueryConstants.PATIENT_PHONE_NUMBER_EXIST_QUERY);
				statement.setLong(1, phone);
				ResultSet resultset = statement.executeQuery();
				if (resultset.next()) {
					patient = new Patient(resultset.getString(1), resultset.getLong(2), resultset.getString(3),
							resultset.getString(4), resultset.getInt(5), resultset.getString(6), resultset.getString(7));
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

			return patient;
		}

		public static int updatePatient(long phone, Patient newpatient) {
			int result = 0;

			Connection connection = null;
			try {
				connection =  MySqlDbcon.getDbConnection();
				connection.setAutoCommit(false);
				PreparedStatement statement = connection.prepareStatement(QueryConstants.PATIENT_UPDATE_QUERY);
				statement.setString(1, newpatient.getFullName());
				statement.setString(2, newpatient.getPassword());
				statement.setString(3, newpatient.getGender());
				statement.setInt(4, newpatient.getAge());
				statement.setString(5, newpatient.getDateofAppointment());
				statement.setString(6, newpatient.getSpecialist());
				statement.setLong(7, newpatient.getPhoneNumber());
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
