package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_company")
public class CompanyType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_type_id")
	private int company_type_id;

	@Column(name = "company_type_name")
	private String companyTypeName;

	@Column(name = "company_type_desc")
	private String companyTypeDesc;

	@Column(name = "is_used")
	private int isUsed;

	public int getCompany_type_id() {
		return company_type_id;
	}

	public void setCompany_type_id(int company_type_id) {
		this.company_type_id = company_type_id;
	}

	public String getCompanyTypeName() {
		return companyTypeName;
	}

	public void setCompanyTypeName(String companyTypeName) {
		this.companyTypeName = companyTypeName;
	}

	public String getCompanyTypeDesc() {
		return companyTypeDesc;
	}

	public void setCompanyTypeDesc(String companyTypeDesc) {
		this.companyTypeDesc = companyTypeDesc;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "CompanyType [company_type_id=" + company_type_id + ", companyTypeName=" + companyTypeName
				+ ", companyTypeDesc=" + companyTypeDesc + ", isUsed=" + isUsed + "]";
	}

}
