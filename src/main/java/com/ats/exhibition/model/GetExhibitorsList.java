package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetExhibitorsList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "exh_id")
	private int exhId;

	@Column(name = "exh_name")
	private String exhName;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "like_status")
	private int likeStatus;

	public String getExhName() {
		return exhName;
	}

	public void setExhName(String exhName) {
		this.exhName = exhName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getLikeStatus() {
		return likeStatus;
	}

	public void setLikeStatus(int likeStatus) {
		this.likeStatus = likeStatus;
	}

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	@Override
	public String toString() {
		return "GetExhibitorsList [exhId=" + exhId + ", exhName=" + exhName + ", eventName=" + eventName
				+ ", likeStatus=" + likeStatus + "]";
	}

}
