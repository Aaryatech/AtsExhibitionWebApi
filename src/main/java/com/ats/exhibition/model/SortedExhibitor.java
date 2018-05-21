package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SortedExhibitor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "map_id")
	private int mapId;

	@Column(name = "exh_id")
	private int exhId;
	
	@Column(name = "exh_name")
	private String exhName;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "is_used")
	private int isUsed;
	
	@Column(name = "location_name")
	private String locationName;
	
	@Column(name = "location_id")
	private int locationId;
	
	@Column(name = "company_type_name")
	private String companyTypeName;
	
	@Column(name = "company_type_id")
	private int companyTypeId;

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
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

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCompanyTypeName() {
		return companyTypeName;
	}

	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
	}

	public int getCompanyTypeId() {
		return companyTypeId;
	}

	public void setCompanyTypeId(int companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	@Override
	public String toString() {
		return "SortedExhibitor [mapId=" + mapId + ", exhId=" + exhId + ", exhName=" + exhName + ", eventId=" + eventId
				+ ", eventName=" + eventName + ", isUsed=" + isUsed + ", locationName=" + locationName + ", locationId="
				+ locationId + ", companyTypeName=" + companyTypeName + ", companyTypeId=" + companyTypeId + "]";
	}
	
	
	

}
