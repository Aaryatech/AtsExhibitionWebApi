package com.ats.exhibition.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_exh_sub_detail")
public class ExhSubDetailWithDate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sub_detail_id")
	private int subDetailId;

	@Column(name = "sub_header_id")
	private int subHeaderId;

	@Column(name = "payment_date")
	private Date paymentDate;

	@Column(name = "payment_amt")
	private float paymentAmt;

	@Column(name = "payment_mode")
	private int paymentMode;

	@Column(name = "tr_no")
	private String trNo;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "cheque_date")
	private Date chequeDate;

	@Column(name = "is_used")
	private int isUsed;

	public int getSubDetailId() {
		return subDetailId;
	}

	public void setSubDetailId(int subDetailId) {
		this.subDetailId = subDetailId;
	}

	public int getSubHeaderId() {
		return subHeaderId;
	}

	public void setSubHeaderId(int subHeaderId) {
		this.subHeaderId = subHeaderId;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public float getPaymentAmt() {
		return paymentAmt;
	}

	public void setPaymentAmt(float paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	public int getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(int paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getTrNo() {
		return trNo;
	}

	public void setTrNo(String trNo) {
		this.trNo = trNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getChequeDate() {
		return chequeDate;
	}

	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "ExhSubDetailWithDate [subDetailId=" + subDetailId + ", subHeaderId=" + subHeaderId + ", paymentDate="
				+ paymentDate + ", paymentAmt=" + paymentAmt + ", paymentMode=" + paymentMode + ", trNo=" + trNo
				+ ", bankName=" + bankName + ", chequeDate=" + chequeDate + ", isUsed=" + isUsed + "]";
	}

	
}
