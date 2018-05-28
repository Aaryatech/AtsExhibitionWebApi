package com.ats.exhibition.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_spin_que")
public class SpinQueHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "t_que_id")
	private int tQueId;

	@Column(name = "emp_id")
	private int queId;

	@Column(name = "exh_id")
	private int exhId;

	@Column(name = "visitor_id")
	private int visitorId;

	@Column(name = "date")
	private Date date;

	@Column(name = "date_time")
	private String dateTime;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "status")
	private int status;
	
	@Transient
	List<SpinQueDetail> spinQueDetailList;
	
	

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

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
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

	
	public List<SpinQueDetail> getSpinQueDetailList() {
		return spinQueDetailList;
	}

	public void setSpinQueDetailList(List<SpinQueDetail> spinQueDetailList) {
		this.spinQueDetailList = spinQueDetailList;
	}

	@Override
	public String toString() {
		return "SpinQueHeader [tQueId=" + tQueId + ", queId=" + queId + ", exhId=" + exhId + ", visitorId=" + visitorId
				+ ", date=" + date + ", dateTime=" + dateTime + ", isUsed=" + isUsed + ", status=" + status
				+ ", spinQueDetailList=" + spinQueDetailList + "]";
	}

}
