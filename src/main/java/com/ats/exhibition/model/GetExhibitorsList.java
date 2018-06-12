package com.ats.exhibition.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetExhibitorsList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int exhId;

	private String exhName;

	private String eventName;

	private int likeStatus;

	private int eventId;

	private String logo;

	private int companyType;

	private String address;

	private String exhCompany;

	public String getExhName() {
		return exhName;
	}

	public void setExhName(String exhName) {
		this.exhName = exhName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getLikeStatus() {
		return likeStatus;
	}

	public void setLikeStatus(int likeStatus) {
		this.likeStatus = likeStatus;
	}

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getCompanyType() {
		return companyType;
	}

	public void setCompanyType(int companyType) {
		this.companyType = companyType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExhCompany() {
		return exhCompany;
	}

	public void setExhCompany(String exhCompany) {
		this.exhCompany = exhCompany;
	}

	@Override
	public String toString() {
		return "GetExhibitorsList [exhId=" + exhId + ", exhName=" + exhName + ", eventName=" + eventName
				+ ", likeStatus=" + likeStatus + ", eventId=" + eventId + ", logo=" + logo + ", companyType="
				+ companyType + ", address=" + address + ", exhCompany=" + exhCompany + "]";
	}

}
