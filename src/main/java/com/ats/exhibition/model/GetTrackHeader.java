package com.ats.exhibition.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetTrackHeader {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "track_id")
	private int trackId;

	@Column(name = "exhi_id")
	private int exhiId;

	@Column(name = "emp_id")
	private int empId;
	
	@Column(name = "emp_name")
	private String empName;

	@Column(name = "date")
	private Date date;

	@Column(name = "loc_lat")
	private float locLat;
	
	@Column(name = "loc_long")
	private float locLong;
	
	@Column(name = "total_km")
	private float totalKm;
	
	@Column(name = "is_used")
	private int isUsed;
	
	@Column(name = "int1")
	private int int1;
	
	@Transient
	ErrorMessage errorMessage;
	
	@Transient
	List<PostTrackDetail> postTrackDetailList;

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public int getExhiId() {
		return exhiId;
	}

	public void setExhiId(int exhiId) {
		this.exhiId = exhiId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getLocLat() {
		return locLat;
	}

	public void setLocLat(float locLat) {
		this.locLat = locLat;
	}

	public float getLocLong() {
		return locLong;
	}

	public void setLocLong(float locLong) {
		this.locLong = locLong;
	}

	public float getTotalKm() {
		return totalKm;
	}

	public void setTotalKm(float totalKm) {
		this.totalKm = totalKm;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	 

	public List<PostTrackDetail> getPostTrackDetailList() {
		return postTrackDetailList;
	}

	public void setPostTrackDetailList(List<PostTrackDetail> postTrackDetailList) {
		this.postTrackDetailList = postTrackDetailList;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	@Override
	public String toString() {
		return "GetTrackHeader [trackId=" + trackId + ", exhiId=" + exhiId + ", empId=" + empId + ", empName=" + empName
				+ ", date=" + date + ", locLat=" + locLat + ", locLong=" + locLong + ", totalKm=" + totalKm
				+ ", isUsed=" + isUsed + ", int1=" + int1 + ", errorMessage=" + errorMessage + ", postTrackDetailList="
				+ postTrackDetailList + "]";
	}

	 
	
	

}
