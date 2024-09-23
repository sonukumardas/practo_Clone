package com.sonu.dao;

public class QueryConstants {

	//patient
	public static final String PATIENT_CREATE_QUERY = "create table patients (fullname varchar(20) not null,phonenumber int(10) unique ,password varchar(20) not null, gender varchar(10) not null, age int(5) primary key, dateofappointment varchar(10) not null, specialist varchar(30) not null );";
	public static final String PATIENT_INSERT_QUERY = "insert into patients(fullname ,phonenumber ,password , gender , age , dateofappointment , specialist) values(?,?,?,?,?,?,?); ";
	public static final String PATIENT_UPDATE_QUERY = "Update patients set fullname=?,password =?, gender =? , age =? , dateofappointment =?, specialist=? where phonenumber=?";
	public static final String PATIENT_DELETE_QUERY = "Delete from patients where phonenumber = ?";
	public static final String PATIENT_SELECT_QUERY = "Select * from patients";
	public static final String PATIENT_PHONE_NUMBER_EXIST_QUERY = "select * from patients where phonenumber=?";
	public static final String PATIENT_LOGIN_QUERY = "select * from patients where phonenumber=? and password=?";

	
	//doctor
		public static final String DOCTOR_CREATE_QUERY = "create table doctors (fullname varchar(20) not null,phonenumber int(10) unique ,password varchar(20) not null, gender varchar(10) not null, age int(5), specialist varchar(30) not null );";
		public static final String DOCTOR_INSERT_QUERY = "insert into doctors(fullname ,phonenumber ,password , gender , age , specialist) values(?,?,?,?,?,?); ";
		public static final String DOCTOR_PHONE_NUMBER_EXIST_QUERY = "select * from doctors where phonenumber=?";
		public static final String DOCTOR_LOGIN_QUERY = "select * from doctors where phonenumber=? and password=?";
		public static final String Doctor_Update_Query="update doctors set fullname =? ,password =?, gender =?, age =?, specialist=? where phonenumber =?";
		public static final String Doctor_Select_Query ="Select * from doctors";
		public static final String Doctor_Delete_Query = "Delete from doctors where phonenumber = ?";

}
