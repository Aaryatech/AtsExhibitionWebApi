package com.ats.exhibition.model.feedback;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GetFbQueTxn {
	
	@Id
	private int fbTxId;
	
	private int fbId;

	private int exhbId;
	 
	private float rating;
	
	private float ratingAvg;
	
	private int queType;
	
	private String options;
	
	private String remark;
	
	private int outOfRating;
	
	private int userId;
	
	private int isUsed;
	
	private int eventId;

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



	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
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


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}

	public float getRatingAvg() {
		return ratingAvg;
	}


	public void setRatingAvg(float ratingAvg) {
		this.ratingAvg = ratingAvg;
	}


	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	@Override
	public String toString() {
		return "GetFbQueTxn [fbId=" + fbId + ", exhbId=" + exhbId + ", fbTxId=" + fbTxId + ", rating=" + rating
				+ ", ratingAvg=" + ratingAvg + ", queType=" + queType + ", options=" + options + ", remark=" + remark
				+ ", outOfRating=" + outOfRating + ", userId=" + userId + ", isUsed=" + isUsed + ", eventId=" + eventId
				+ ", question=" + question + "]";
	}

}
