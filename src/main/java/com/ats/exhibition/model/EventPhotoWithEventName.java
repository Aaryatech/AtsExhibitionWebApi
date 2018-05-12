package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventPhotoWithEventName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "photo_id")
	private int photoId;

	@Column(name = "event_id")
	private int eventId;
	
	@Column(name = "event_name")
	private String eventName;

	@Column(name = "photo_link")
	private String photoLink;

	@Column(name = "is_used")
	private int isUsed;

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "EventPhotoWithEventName [photoId=" + photoId + ", eventId=" + eventId + ", eventName=" + eventName
				+ ", photoLink=" + photoLink + ", isUsed=" + isUsed + "]";
	}

	
}
