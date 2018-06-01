package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_emp_tracking_detail")
public class PostTrackDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "track_detail_id")
	private int trackDetailId;
	
	@Column(name = "track_id")
	private int trackId;
 
	@Column(name = "loc_lat")
	private float locLat;
	
	@Column(name = "loc_long")
	private float locLong;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "km")
	private int km;
	
	@Column(name = "is_used")
	private int isUsed;

	public int getTrackDetailId() {
		return trackDetailId;
	}

	public void setTrackDetailId(int trackDetailId) {
		this.trackDetailId = trackDetailId;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "PostTrackDetail [trackDetailId=" + trackDetailId + ", trackId=" + trackId + ", locLat=" + locLat
				+ ", locLong=" + locLong + ", address=" + address + ", km=" + km + ", isUsed=" + isUsed + "]";
	}
	
	
	

}
