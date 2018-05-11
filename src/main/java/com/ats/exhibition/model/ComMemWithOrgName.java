package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class ComMemWithOrgName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mem_id")
	private int memId;

	@Column(name = "org_id")
	private int orgId;
	
	@Column(name = "org_name")
	private String orgName;


	@Column(name = "member_name")
	private String memberName;

	@Column(name = "designation")
	private String designation;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "remark")
	private String remark;

	
	@Column(name = "is_used")
	private int isUsed;
	
	
	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ComMemWithOrgName [memId=" + memId + ", orgId=" + orgId + ", orgName=" + orgName + ", memberName="
				+ memberName + ", designation=" + designation + ", contactNo=" + contactNo + ", emailId=" + emailId
				+ ", companyName=" + companyName + ", remark=" + remark + ", isUsed=" + isUsed + "]";
	}
	
	


}
