
package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_org_subscription")

public class OrgSubscription {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sub_id")
	private int subId;

	@Column(name = "org_id")
	private int orgId;

	@Column(name = "from_date")
	private String fromDate;

	@Column(name = "to_date")
	private String toDate;

	@Column(name = "trans_datetime")
	private String transDatetime;

	@Column(name = "pkg_id")
	private int pkgId;

	@Column(name = "pkg_amt")
	private float pkgAmt;

	@Column(name = "paid_amt")
	private float paidAmt;

	@Column(name = "rem_amt")
	private float remAmt;

	@Column(name = "status")
	private int status;

	@Column(name = "is_used")
	private int isUsed;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getTransDatetime() {
		return transDatetime;
	}

	public void setTransDatetime(String transDatetime) {
		this.transDatetime = transDatetime;
	}

	public int getPkgId() {
		return pkgId;
	}

	public void setPkgId(int pkgId) {
		this.pkgId = pkgId;
	}

	public float getPkgAmt() {
		return pkgAmt;
	}

	public void setPkgAmt(float pkgAmt) {
		this.pkgAmt = pkgAmt;
	}

	public float getPaidAmt() {
		return paidAmt;
	}

	public void setPaidAmt(float paidAmt) {
		this.paidAmt = paidAmt;
	}

	public float getRemAmt() {
		return remAmt;
	}

	public void setRemAmt(float remAmt) {
		this.remAmt = remAmt;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "OrgSubscription [subId=" + subId + ", orgId=" + orgId + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", transDatetime=" + transDatetime + ", pkgId=" + pkgId + ", pkgAmt=" + pkgAmt + ", paidAmt="
				+ paidAmt + ", remAmt=" + remAmt + ", isUsed=" + isUsed + ", status=" + status + "]";
	}

}
