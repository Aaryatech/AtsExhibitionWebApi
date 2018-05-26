package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SpinQueDetailWithName {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "t_que_id")
	private int tQueId;

	@Column(name = "que_id")
	private int queId;

	@Column(name = "exh_id")
	private int exhId;

	private String exhName;

	@Column(name = "visitor_id")
	private int visitorId;

	private String visitorName;

	@Column(name = "actual_ans")
	private String actualAns;

	@Column(name = "date_time")
	private String dateTime;

	@Column(name = "is_used")
	private int isUsed;

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

	public String getExhName() {
		return exhName;
	}

	public void setExhName(String exhName) {
		this.exhName = exhName;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getActualAns() {
		return actualAns;
	}

	public void setActualAns(String actualAns) {
		this.actualAns = actualAns;
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

	@Override
	public String toString() {
		return "SpinQueDetailWithName [tQueId=" + tQueId + ", queId=" + queId + ", exhId=" + exhId + ", exhName="
				+ exhName + ", visitorId=" + visitorId + ", visitorName=" + visitorName + ", actualAns=" + actualAns
				+ ", dateTime=" + dateTime + ", isUsed=" + isUsed + "]";
	}

}
