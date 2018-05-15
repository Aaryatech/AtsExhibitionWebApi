package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_organiser")

public class Organiser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "org_id")
	private int orgId;

	@Column(name = "org_name")
	private String orgName;

	@Column(name = "org_address")
	private String orgAddress;

	@Column(name = "org_contact_no")
	private String orgContactNo;

	@Column(name = "org_email_id")
	private String orgEmailId;

	@Column(name = "website_link")
	private String websiteLink;

	@Column(name = "org_type")
	private int orgType;

	@Column(name = "about_org")
	private String aboutOrg;

	@Column(name = "work_area_keywords")
	private String workAreaKeywords;

	@Column(name = "org_image")
	private String orgImage;

	@Column(name = "color1")
	private String color1;

	@Column(name = "color2")
	private String color2;

	@Column(name = "color3")
	private String color3;

	@Column(name = "color4")
	private String color4;

	@Column(name = "user_mob")
	private String userMob;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "is_active")
	private int isActive;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "int11")
	private int int11;

	@Column(name = "varchar1")
	private String varchar1;

	@Column(name = "varchar2")
	private String varchar2;

	@Column(name = "varchar3")
	private String varchar3;

	@Column(name = "bool1")
	private int bool1;

	@Column(name = "location_id")
	private int locationId;

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

	public String getOrgAddress() {
		return orgAddress;
	}

	public void setOrgAddress(String orgAddress) {
		this.orgAddress = orgAddress;
	}

	public String getOrgContactNo() {
		return orgContactNo;
	}

	public void setOrgContactNo(String orgContactNo) {
		this.orgContactNo = orgContactNo;
	}

	public String getOrgEmailId() {
		return orgEmailId;
	}

	public void setOrgEmailId(String orgEmailId) {
		this.orgEmailId = orgEmailId;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public int getOrgType() {
		return orgType;
	}

	public void setOrgType(int orgType) {
		this.orgType = orgType;
	}

	public String getAboutOrg() {
		return aboutOrg;
	}

	public void setAboutOrg(String aboutOrg) {
		this.aboutOrg = aboutOrg;
	}

	public String getWorkAreaKeywords() {
		return workAreaKeywords;
	}

	public void setWorkAreaKeywords(String workAreaKeywords) {
		this.workAreaKeywords = workAreaKeywords;
	}

	public String getOrgImage() {
		return orgImage;
	}

	public void setOrgImage(String orgImage) {
		this.orgImage = orgImage;
	}

	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		this.color1 = color1;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}

	public String getColor3() {
		return color3;
	}

	public void setColor3(String color3) {
		this.color3 = color3;
	}

	public String getColor4() {
		return color4;
	}

	public void setColor4(String color4) {
		this.color4 = color4;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public int getInt11() {
		return int11;
	}

	public void setInt11(int int11) {
		this.int11 = int11;
	}

	public String getVarchar1() {
		return varchar1;
	}

	public void setVarchar1(String varchar1) {
		this.varchar1 = varchar1;
	}

	public String getVarchar2() {
		return varchar2;
	}

	public void setVarchar2(String varchar2) {
		this.varchar2 = varchar2;
	}

	public String getVarchar3() {
		return varchar3;
	}

	public void setVarchar3(String varchar3) {
		this.varchar3 = varchar3;
	}

	public int getBool1() {
		return bool1;
	}

	public void setBool1(int bool1) {
		this.bool1 = bool1;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Organiser [orgId=" + orgId + ", orgName=" + orgName + ", orgAddress=" + orgAddress + ", orgContactNo="
				+ orgContactNo + ", orgEmailId=" + orgEmailId + ", websiteLink=" + websiteLink + ", orgType=" + orgType
				+ ", aboutOrg=" + aboutOrg + ", workAreaKeywords=" + workAreaKeywords + ", orgImage=" + orgImage
				+ ", color1=" + color1 + ", color2=" + color2 + ", color3=" + color3 + ", color4=" + color4
				+ ", userMob=" + userMob + ", userPassword=" + userPassword + ", isActive=" + isActive + ", isUsed="
				+ isUsed + ", int11=" + int11 + ", varchar1=" + varchar1 + ", varchar2=" + varchar2 + ", varchar3="
				+ varchar3 + ", bool1=" + bool1 + ", locationId=" + locationId + "]";
	}

}
