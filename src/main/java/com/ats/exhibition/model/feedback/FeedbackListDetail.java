package com.ats.exhibition.model.feedback;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeedbackListDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fb_tx_id")
	private int fbTxId;

	private int exhbId;

	private int fbId;

	private int rating;

	private int eventId;

	private int queType;
	private String options;
	private String remark;

	private int outOfRating;

	private int visitorId;

	private int isUsed;

	private String visitorName;

	private String question;

	public int getFbTxId() {
		return fbTxId;
	}

	public void setFbTxId(int fbTxId) {
		this.fbTxId = fbTxId;
	}

	public int getExhbId() {
		return exhbId;
	}

	public void setExhbId(int exhbId) {
		this.exhbId = exhbId;
	}

	public int getFbId() {
		return fbId;
	}

	public void setFbId(int fbId) {
		this.fbId = fbId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getOutOfRating() {
		return outOfRating;
	}

	public void setOutOfRating(int outOfRating) {
		this.outOfRating = outOfRating;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "FeedbackListDetail [fbTxId=" + fbTxId + ", exhbId=" + exhbId + ", fbId=" + fbId + ", rating=" + rating
				+ ", eventId=" + eventId + ", queType=" + queType + ", options=" + options + ", remark=" + remark
				+ ", outOfRating=" + outOfRating + ", visitorId=" + visitorId + ", isUsed=" + isUsed + ", visitorName="
				+ visitorName + ", question=" + question + "]";
	}

}
