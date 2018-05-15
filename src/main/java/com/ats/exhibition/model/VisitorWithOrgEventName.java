package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VisitorWithOrgEventName {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "visitor_id")
	private int visitorId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "org_id")
	private int orgId;

	@Column(name = "org_name")
	private String orgName;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "visitor_name")
	private String visitorName;

	@Column(name = "visitor_email")
	private String visitorEmail;

	@Column(name = "visitor_mobile")
	private String visitorMobile;

	@Column(name = "visitor_represent")
	private String visitorRepresent;

	@Column(name = "is_active")
	private int isActive;

	@Column(name = "is_used")
	private int isUsed;
	
	
	@Column(name = "location_id")
	private int locationId;
	
	@Column(name = "company_type_id")
	private int companyTypeId;

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

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorEmail() {
		return visitorEmail;
	}

	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}

	public String getVisitorMobile() {
		return visitorMobile;
	}

	public void setVisitorMobile(String visitorMobile) {
		this.visitorMobile = visitorMobile;
	}

	public String getVisitorRepresent() {
		return visitorRepresent;
	}

	public void setVisitorRepresent(String visitorRepresent) {
		this.visitorRepresent = visitorRepresent;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getCompanyTypeId() {
		return companyTypeId;
	}

	public void setCompanyTypeId(int companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	@Override
	public String toString() {
		return "VisitorWithOrgEventName [visitorId=" + visitorId + ", eventId=" + eventId + ", orgId=" + orgId
				+ ", orgName=" + orgName + ", eventName=" + eventName + ", visitorName=" + visitorName
				+ ", visitorEmail=" + visitorEmail + ", visitorMobile=" + visitorMobile + ", visitorRepresent="
				+ visitorRepresent + ", isActive=" + isActive + ", isUsed=" + isUsed + ", locationId=" + locationId
				+ ", companyTypeId=" + companyTypeId + "]";
	}

	

	

}
