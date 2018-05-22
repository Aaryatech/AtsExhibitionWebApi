package com.ats.exhibition.model.feedback;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_feedback_que")

public class FeedbackQue implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fb_id")
	private int fbId;

	@Column(name = "exhb_id")
	private int exhbId;

	@Column(name = "question")
	private String question;

	@Column(name = "que_desc")
	private String queDesc;
	
	@Column(name = "que_type")
	private int queType;
	
	@Column(name = "options")
	private String options;
	
	@Column(name = "is_active")
	private int isActive;

	@Column(name = "is_used")
	private int isUsed;
	
	
	@Column(name = "out_of_rating")
	private int outOfRating;
	

	public int getFbId() {
		return fbId;
	}

	public void setFbId(int fbId) {
		this.fbId = fbId;
	}

	public int getExhbId() {
		return exhbId;
	}

	public void setExhbId(int exhbId) {
		this.exhbId = exhbId;
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

	public int getQueType() {
		return queType;
	}

	public void setQueType(int queType) {
		this.queType = queType;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
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

	public int getOutOfRating() {
		return outOfRating;
	}

	public void setOutOfRating(int outOfRating) {
		this.outOfRating = outOfRating;
	}

	@Override
	public String toString() {
		return "FeedbackQue [fbId=" + fbId + ", exhbId=" + exhbId + ", question=" + question + ", queDesc=" + queDesc
				+ ", queType=" + queType + ", options=" + options + ", isActive=" + isActive + ", isUsed=" + isUsed
				+ ", outOfRating=" + outOfRating + "]";
	}
	

}
