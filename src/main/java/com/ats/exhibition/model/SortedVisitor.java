package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SortedVisitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "visitor_event_id")
	private int visitorEventId;

	@Column(name = "visitor_id")
	private int visitorId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "subscribe_status")
	private int subscribeStatus;
	
	@Column(name = "visitor_name")
	private String visitorName;
	
	@Column(name = "location_id")
	private int locationId;
	
	@Column(name = "location_name")
	private String locationName;
	
	@Column(name = "company_type_id")
	private int companyTypeId;
	
	@Column(name = "company_type_name")
	private String companyTypeName;

	public int getVisitorEventId() {
		return visitorEventId;
	}

	public void setVisitorEventId(int visitorEventId) {
		this.visitorEventId = visitorEventId;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getSubscribeStatus() {
		return subscribeStatus;
	}

	public void setSubscribeStatus(int subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

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

	public int getCompanyTypeId() {
		return companyTypeId;
	}

	public void setCompanyTypeId(int companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	public String getCompanyTypeName() {
		return companyTypeName;
	}

	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
	}

	@Override
	public String toString() {
		return "SortedVisitor [visitorEventId=" + visitorEventId + ", visitorId=" + visitorId + ", eventId=" + eventId
				+ ", subscribeStatus=" + subscribeStatus + ", visitorName=" + visitorName + ", locationId=" + locationId
				+ ", locationName=" + locationName + ", companyTypeId=" + companyTypeId + ", companyTypeName="
				+ companyTypeName + "]";
	}
	
	
	
	
 

}
