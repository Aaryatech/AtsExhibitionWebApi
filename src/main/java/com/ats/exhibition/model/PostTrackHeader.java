package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_emp_tracking_header")
public class PostTrackHeader {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "track_id")
	private int trackId;

	@Column(name = "exhi_id")
	private int exhiId;

	@Column(name = "emp_id")
	private int empId;

	@Column(name = "date")
	private String date;

	@Column(name = "loc_lat")
	private float locLat;
	
	@Column(name = "loc_long")
	private float locLong;
	
	@Column(name = "total_km")
	private float totalKm;
	
	@Column(name = "is_used")
	private float isUsed;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
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

	public float getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(float isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "PostTrackHeader [trackId=" + trackId + ", exhiId=" + exhiId + ", empId=" + empId + ", date=" + date
				+ ", locLat=" + locLat + ", locLong=" + locLong + ", totalKm=" + totalKm + ", isUsed=" + isUsed + "]";
	}
	
	
	

}
