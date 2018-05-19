package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_visitor_exhibitor")
public class VisitorExhibitorMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "visitor_exhibitor_id")
	private int visitorExhibitorId;

	@Column(name = "visitor_id")
	private int visitorId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "exhibitor_id")
	private int exhibitorId;

	@Column(name = "like_status")
	private int likeStatus;

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

	public int getExhibitorId() {
		return exhibitorId;
	}

	public void setExhibitorId(int exhibitorId) {
		this.exhibitorId = exhibitorId;
	}

	public int getLikeStatus() {
		return likeStatus;
	}

	public void setLikeStatus(int likeStatus) {
		this.likeStatus = likeStatus;
	}

	@Override
	public String toString() {
		return "VisitorExhibitorMapping [visitorExhibitorId=" + visitorExhibitorId + ", visitorId=" + visitorId
				+ ", eventId=" + eventId + ", exhibitorId=" + exhibitorId + ", likeStatus=" + likeStatus + "]";
	}

}
