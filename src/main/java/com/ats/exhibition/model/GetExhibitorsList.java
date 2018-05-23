package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class GetExhibitorsList {

	@Id
	@Column(name = "visitor_exhibitor_id")
	private String visitor_exhibitor_id;
	
	public String getVisitor_exhibitor_id() {
		return visitor_exhibitor_id;
	}

	public void setVisitor_exhibitor_id(String visitor_exhibitor_id) {
		this.visitor_exhibitor_id = visitor_exhibitor_id;
	}

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

	@Override
	public String toString() {
		return "GetExhibitorsList [visitor_exhibitor_id=" + visitor_exhibitor_id + ", exhName=" + exhName
				+ ", eventName=" + eventName + ", likeStatus=" + likeStatus + "]";
	}

}
