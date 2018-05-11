package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_exhibitor")
public class Exhibitor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "exh_id")
	private int exhId;
	
	@Column(name = "org_id")
	private int orgId;


	@Column(name = "exh_name")
	private String exhName;

	@Column(name = "exh_company")
	private String exhCompany;

	@Column(name = "logo")
	private String logo;

	@Column(name = "contact_person_name1")
	private String contactPersonName1;

	@Column(name = "contact_person_name2")
	private String contactPersonName2;

	@Column(name = "person_mob1")
	private String personMob1;

	@Column(name = "person_mob2")
	private String personMob2;

	@Column(name = "person_email1")
	private String personEmail1;

	@Column(name = "person_email2")
	private String personEmail2;

	@Column(name = "address")
	private String address;

	@Column(name = "comp_lat")
	private String compLat;

	@Column(name = "comp_long")
	private String compLong;

	@Column(name = "user_mob")
	private String userMob;

	@Column(name = "password")
	private String password;

	@Column(name = "about_company")
	private String aboutCompany;

	@Column(name = "company_type")
	private int companyType;

	@Column(name = "is_used")
	private int isUsed;

	
	
	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
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

	public String getExhCompany() {
		return exhCompany;
	}

	public void setExhCompany(String exhCompany) {
		this.exhCompany = exhCompany;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getContactPersonName1() {
		return contactPersonName1;
	}

	public void setContactPersonName1(String contactPersonName1) {
		this.contactPersonName1 = contactPersonName1;
	}

	public String getContactPersonName2() {
		return contactPersonName2;
	}

	public void setContactPersonName2(String contactPersonName2) {
		this.contactPersonName2 = contactPersonName2;
	}

	public String getPersonMob1() {
		return personMob1;
	}

	public void setPersonMob1(String personMob1) {
		this.personMob1 = personMob1;
	}

	public String getPersonMob2() {
		return personMob2;
	}

	public void setPersonMob2(String personMob2) {
		this.personMob2 = personMob2;
	}

	public String getPersonEmail1() {
		return personEmail1;
	}

	public void setPersonEmail1(String personEmail1) {
		this.personEmail1 = personEmail1;
	}

	public String getPersonEmail2() {
		return personEmail2;
	}

	public void setPersonEmail2(String personEmail2) {
		this.personEmail2 = personEmail2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompLat() {
		return compLat;
	}

	public void setCompLat(String compLat) {
		this.compLat = compLat;
	}

	public String getCompLong() {
		return compLong;
	}

	public void setCompLong(String compLong) {
		this.compLong = compLong;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAboutCompany() {
		return aboutCompany;
	}

	public void setAboutCompany(String aboutCompany) {
		this.aboutCompany = aboutCompany;
	}

	public int getCompanyType() {
		return companyType;
	}

	public void setCompanyType(int companyType) {
		this.companyType = companyType;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "Exhibitor [exhId=" + exhId + ", orgId=" + orgId + ", exhName=" + exhName + ", exhCompany=" + exhCompany
				+ ", logo=" + logo + ", contactPersonName1=" + contactPersonName1 + ", contactPersonName2="
				+ contactPersonName2 + ", personMob1=" + personMob1 + ", personMob2=" + personMob2 + ", personEmail1="
				+ personEmail1 + ", personEmail2=" + personEmail2 + ", address=" + address + ", compLat=" + compLat
				+ ", compLong=" + compLong + ", userMob=" + userMob + ", password=" + password + ", aboutCompany="
				+ aboutCompany + ", companyType=" + companyType + ", isUsed=" + isUsed + "]";
	}

}
