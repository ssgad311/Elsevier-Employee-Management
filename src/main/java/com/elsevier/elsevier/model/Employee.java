package com.elsevier.elsevier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name  = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "employee_id")
	private Integer id;
	
	@Column(name = "employee_name")
	private String name;
	
	@Column(name = "employee_username")
	private String username;

	@Column(name = "employee_password")
	private String password;
	
	@Column(name = "employee_department")
	private String department;
	
	@Column(name = "employee_designation")
	private String designation;
	
	@Column(name = "employee_location")
	private String location;
	
	@Column(name = "employee_mobile_no")
	private String mobileNo;
	
	@Column(name = "employee_email_id")
	private String emailId;
	
	@Column(name = "employee_gender")
	private String gender;
	
	@Column(name = "employee_salary")
	private Double salary;
	
	@Column(name = "employee_photo", nullable = true, length = 64)
    private String photos;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}
	

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}
	
	
	
}
