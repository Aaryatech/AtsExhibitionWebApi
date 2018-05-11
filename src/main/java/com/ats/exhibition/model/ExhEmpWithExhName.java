package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExhEmpWithExhName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int empId;

	@Column(name = "exh_id")
	private int exhId;
	
	@Column(name = "exh_name")
	private String exhName;

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

	public String getExhName() {
		return exhName;
	}

	public void setExhName(String exhName) {
		this.exhName = exhName;
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

	@Override
	public String toString() {
		return "ExhEmpWithExhName [empId=" + empId + ", exhId=" + exhId + ", exhName=" + exhName + ", empName="
				+ empName + ", empDesignation=" + empDesignation + ", empMobile=" + empMobile + ", empEmail=" + empEmail
				+ ", empPhoto=" + empPhoto + ", empEducation=" + empEducation + ", isUsed=" + isUsed + "]";
	}


}
