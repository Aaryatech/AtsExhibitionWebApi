package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_visitor_event")
public class EventVisitorMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "visitor_event_id")
	private int visitorEventId;
	
	@Column(name = "visitor_id")
	private int visitorId;
	
	@Column(name = "event_id")
	private int eventId;
	
	@Column(name = "subscribe_status")
	private int subscribeStatus;

	public int getVisitorEventId() {
		return visitorEventId;
	}

	public void setVisitorEventId(int visitorEventId) {
		this.visitorEventId = visitorEventId;
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

	public int getSubscribeStatus() {
		return subscribeStatus;
	}

	public void setSubscribeStatus(int subscribeStatus) {
		this.subscribeStatus = subscribeStatus;
	}

	@Override
	public String toString() {
		return "EventVisitorMapping [visitorEventId=" + visitorEventId + ", visitorId=" + visitorId + ", eventId="
				+ eventId + ", subscribeStatus=" + subscribeStatus + "]";
	}
	
	
}
