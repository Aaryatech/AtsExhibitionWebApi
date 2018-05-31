package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VisitorByExhiId {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "visitor_exhibitor_id")
	private int visitorExhibitorId;

	@Column(name = "visitor_id")
	private int visitorId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "exhibitor_id")
	private int exhibitorTd;
	
	@Column(name = "like_status")
	private int likeStatus;

	@Column(name = "visitor_name")
	private String visitorName;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "exh_name")
	private String exhName;

	public int getVisitorExhibitorId() {
		return visitorExhibitorId;
	}

	public void setVisitorExhibitorId(int visitorExhibitorId) {
		this.visitorExhibitorId = visitorExhibitorId;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getExhibitorTd() {
		return exhibitorTd;
	}

	public void setExhibitorTd(int exhibitorTd) {
		this.exhibitorTd = exhibitorTd;
	}

	public int getLikeStatus() {
		return likeStatus;
	}

	public void setLikeStatus(int likeStatus) {
		this.likeStatus = likeStatus;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getExhName() {
		return exhName;
	}

	public void setExhName(String exhName) {
		this.exhName = exhName;
	}

	@Override
	public String toString() {
		return "VisitorByExhiId [visitorExhibitorId=" + visitorExhibitorId + ", visitorId=" + visitorId + ", eventId="
				+ eventId + ", exhibitorTd=" + exhibitorTd + ", likeStatus=" + likeStatus + ", visitorName="
				+ visitorName + ", eventName=" + eventName + ", exhName=" + exhName + "]";
	}
	
	

	

	 

}
