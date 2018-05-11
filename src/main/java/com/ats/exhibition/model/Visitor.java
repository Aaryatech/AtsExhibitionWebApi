package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_visitor")
public class Visitor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "visitor_id")
	private int visitorId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "org_id")
	private int orgId;

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

	@Override
	public String toString() {
		return "Visitor [visitorId=" + visitorId + ", eventId=" + eventId + ", orgId=" + orgId + ", visitorName="
				+ visitorName + ", visitorEmail=" + visitorEmail + ", visitorMobile=" + visitorMobile
				+ ", visitorRepresent=" + visitorRepresent + ", isActive=" + isActive + ", isUsed=" + isUsed + "]";
	}
	
	
	

}
