package com.ats.exhibition.model.feedback;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_feedback")

public class FeedbackTxn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fb_tx_id")
	private int fbTxId;

	@Column(name = "exhb_id")
	private int exhbId;
	
	
	@Column(name = "fb_id")
	private int fbId;

	@Column(name = "rating")
	private int rating;
	
	@Column(name = "que_type")
	private int queType;
	
	@Column(name = "options")
	private String options;
	
	@Column(name = "remark")
	private String remark;
	
	@Column(name = "out_of_rating")
	private int outOfRating;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "is_used")
	private int isUsed;
	
	@Column(name = "event_id")
	private int eventId;

	

	@Override
	public String toString() {
		return "FeedbackTxn [fbTxId=" + fbTxId + ", exhbId=" + exhbId + ", fbId=" + fbId + ", rating=" + rating
				+ ", queType=" + queType + ", options=" + options + ", remark=" + remark + ", outOfRating="
				+ outOfRating + ", userId=" + userId + ", isUsed=" + isUsed + ", eventId=" + eventId + "]";
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}
	
	

}
