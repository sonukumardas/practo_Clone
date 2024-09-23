package com.sonu.doctor;

public class Doctor {

	private String fullName;
	private Long phoneNumber;
	private String password;
	private String gender;
	private int age;
	private String specialist;

	public Doctor() {

	}

	public Doctor(String fullName, Long phoneNumber, String password, String gender, int age, String specialist) {
		super();
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.specialist = specialist;
	}

	@Override
	public String toString() {
		return "Doctor [fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", password=" + password + ", gender="
				+ gender + ", age=" + age + ", specialist=" + specialist + "]";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecialist() {
		return specialist;
	}

	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}

}
