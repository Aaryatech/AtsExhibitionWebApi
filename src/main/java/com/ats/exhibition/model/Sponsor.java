package com.ats.exhibition.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_sponsor")
public class Sponsor implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sponsorId;
	
	private int eventId;

	private String name;
	
	private String company;
	
	private String designation;
	
    private String photo;
	
	private String email;
	
	private String website;
	
	private String mobile;
	
	private String remark;
	
	private int isUsed;

	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getSponsorId() {
		return sponsorId;
	}

	public int getEventId() {
		return eventId;
	}

	public String getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	public String getDesignation() {
		return designation;
	}

	public String getPhoto() {
		return photo;
	}

	public String getEmail() {
		return email;
	}

	public String getWebsite() {
		return website;
	}

	public String getRemark() {
		return remark;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "Sponsor [sponsorId=" + sponsorId + ", eventId=" + eventId + ", name=" + name + ", company=" + company
				+ ", designation=" + designation + ", photo=" + photo + ", email=" + email + ", website=" + website
				+ ", mobile=" + mobile + ", remark=" + remark + ", isUsed=" + isUsed + "]";
	}

	
    
}
