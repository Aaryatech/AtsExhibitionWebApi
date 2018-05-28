package com.ats.exhibition.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_spin_que_detail")
public class SpinQueDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "t_que_detail_id")
	private int tQueDetailId;

	@Column(name = "t_que_id")
	private int tQueId;

	@Column(name = "que_id")
	private int queId;

	@Column(name = "date")
	private Date date;

	@Column(name = "actual_ans")
	private String actualAns;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "status")
	private int status;

	public int gettQueDetailId() {
		return tQueDetailId;
	}

	public void settQueDetailId(int tQueDetailId) {
		this.tQueDetailId = tQueDetailId;
	}

	public int gettQueId() {
		return tQueId;
	}

	public void settQueId(int tQueId) {
		this.tQueId = tQueId;
	}

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getActualAns() {
		return actualAns;
	}

	public void setActualAns(String actualAns) {
		this.actualAns = actualAns;
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
		return "SpinQueDetail [tQueDetailId=" + tQueDetailId + ", tQueId=" + tQueId + ", queId=" + queId + ", date="
				+ date + ", actualAns=" + actualAns + ", isUsed=" + isUsed + ", status=" + status + "]";
	}

}
