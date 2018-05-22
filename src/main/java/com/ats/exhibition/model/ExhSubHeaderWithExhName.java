package com.ats.exhibition.model;
 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ExhSubHeaderWithExhName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sub_header_id")
	private int subId;

	@Column(name = "exh_id")
	private int exhId;
	
	@Column(name = "exh_name")
	private String exhName;


	@Column(name = "from_date")
	private Date fromDate;

	@Column(name = "to_date")
	private Date toDate;

	@Column(name = "payment_status")
	private int paymentStatus;

	@Column(name = "totol_amt")
	private float totolAmt;

	@Column(name = "paid_amt")
	private float paidAmt;

	@Column(name = "rem_amt")
	private float remAmt;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "status")
	private int status;

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
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
	
	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public float getTotolAmt() {
		return totolAmt;
	}

	public void setTotolAmt(float totolAmt) {
		this.totolAmt = totolAmt;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ExhSubHeaderWithExhName [subId=" + subId + ", exhId=" + exhId + ", exhName=" + exhName + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", paymentStatus=" + paymentStatus + ", totolAmt=" + totolAmt
				+ ", paidAmt=" + paidAmt + ", remAmt=" + remAmt + ", isUsed=" + isUsed + ", status=" + status + "]";
	}


}
