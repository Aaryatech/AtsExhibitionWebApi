package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SpinQueHeaderWithName {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "que_id")
	private int queId;

	@Column(name = "exh_id")
	private int exhId;

	private String exhName;

	@Column(name = "question")
	private String question;

	@Column(name = "que_desc")
	private String queDesc;

	@Column(name = "date")
	private String date;

	@Column(name = "is_active")
	private int isActive;

	@Column(name = "is_used")
	private int isUsed;

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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQueDesc() {
		return queDesc;
	}

	public void setQueDesc(String queDesc) {
		this.queDesc = queDesc;
	}

	public String getDate() {
		return date;
	}


	@JsonFormat(locale = "hi", timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setDate(String date) {
		this.date = date;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "SpinQueHeaderWithName [queId=" + queId + ", exhId=" + exhId + ", exhName=" + exhName + ", question="
				+ question + ", queDesc=" + queDesc + ", date=" + date + ", isActive=" + isActive + ", isUsed=" + isUsed
				+ "]";
	}

}
