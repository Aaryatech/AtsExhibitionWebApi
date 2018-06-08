package com.ats.exhibition.model.feedback;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class FeedbackListHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fb_tx_id")
	private int fbTxId;

	private int exhbId;

	private int rating;

	private int outOfRating;

	private int visitorId;

	private int isUsed;

	private int eventId;

	private String visitorName;

	@Transient
	List<FeedbackListDetail> feedbackListDetailList;

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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public List<FeedbackListDetail> getFeedbackListDetailList() {
		return feedbackListDetailList;
	}

	public void setFeedbackListDetailList(List<FeedbackListDetail> feedbackListDetailList) {
		this.feedbackListDetailList = feedbackListDetailList;
	}

	@Override
	public String toString() {
		return "FeedbackListHeader [fbTxId=" + fbTxId + ", exhbId=" + exhbId + ", rating=" + rating + ", outOfRating="
				+ outOfRating + ", visitorId=" + visitorId + ", isUsed=" + isUsed + ", eventId=" + eventId
				+ ", visitorName=" + visitorName + ", feedbackListDetailList=" + feedbackListDetailList + "]";
	}

}
