package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id")
	private int locationId;

	@Column(name = "location_name")
	private String locationName;

	@Column(name = "location_lat")
	private String locationLat;

	@Column(name = "location_long")
	private String locationLong;

	@Column(name = "remark")
	private String remark;

	@Column(name = "is_used")
	private int isUsed;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationLat() {
		return locationLat;
	}

	public void setLocationLat(String locationLat) {
		this.locationLat = locationLat;
	}

	public String getLocationLong() {
		return locationLong;
	}

	public void setLocationLong(String locationLong) {
		this.locationLong = locationLong;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", locationLat=" + locationLat
				+ ", locationLong=" + locationLong + ", remark=" + remark + ", isUsed=" + isUsed + "]";
	}

}
