package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_package")
public class Package1 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pkg_id")
	private int pkgId;

	@Column(name = "pkg_name")
	private String pkgName;

	@Column(name = "sub_duration")
	private int subDuration;

	@Column(name = "pkg_amt")
	private float pkgAmt;

	@Column(name = "is_used")
	private int isUsed;
	
	@Column(name = "pkg_type")
	private int pkgType;

	public int getPkgId() {
		return pkgId;
	}

	public void setPkgId(int pkgId) {
		this.pkgId = pkgId;
	}

	public String getPkgName() {
		return pkgName;
	}

	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}

	public int getSubDuration() {
		return subDuration;
	}

	public void setSubDuration(int subDuration) {
		this.subDuration = subDuration;
	}

	public float getPkgAmt() {
		return pkgAmt;
	}

	public void setPkgAmt(float pkgAmt) {
		this.pkgAmt = pkgAmt;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getPkgType() {
		return pkgType;
	}

	public void setPkgType(int pkgType) {
		this.pkgType = pkgType;
	}

	@Override
	public String toString() {
		return "Package1 [pkgId=" + pkgId + ", pkgName=" + pkgName + ", subDuration=" + subDuration + ", pkgAmt="
				+ pkgAmt + ", isUsed=" + isUsed + ", pkgType=" + pkgType + "]";
	}

}
