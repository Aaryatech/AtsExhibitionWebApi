package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_exh_employee")
public class ExhEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int empId;

	@Column(name = "exh_id")
	private int exhId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_designation")
	private String empDesignation;

	@Column(name = "emp_mobile")
	private String empMobile;

	@Column(name = "emp_email")
	private String empEmail;

	@Column(name = "emp_photo")
	private String empPhoto;

	@Column(name = "emp_education")
	private String empEducation;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "password")
	private String password;

	@Column(name = "token")
	private String token;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	public String getEmpMobile() {
		return empMobile;
	}

	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPhoto() {
		return empPhoto;
	}

	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}

	public String getEmpEducation() {
		return empEducation;
	}

	public void setEmpEducation(String empEducation) {
		this.empEducation = empEducation;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "ExhEmployee [empId=" + empId + ", exhId=" + exhId + ", empName=" + empName + ", empDesignation="
				+ empDesignation + ", empMobile=" + empMobile + ", empEmail=" + empEmail + ", empPhoto=" + empPhoto
				+ ", empEducation=" + empEducation + ", isUsed=" + isUsed + ", password=" + password + ", token="
				+ token + "]";
	}

}
