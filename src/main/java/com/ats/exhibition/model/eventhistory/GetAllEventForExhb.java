package com.ats.exhibition.model.eventhistory;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//sachin 
public class GetAllEventForExhb {
	
	@Id
	private int eventId;
	
	private String eventName;
	
	private String exhName;

	public int getEventId() {
		return eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public String getExhName() {
		return exhName;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setExhName(String exhName) {
		this.exhName = exhName;
	}

	@Override
	public String toString() {
		return "GetAllEventForExhb [eventId=" + eventId + ", eventName=" + eventName + ", exhName=" + exhName + "]";
	}

}
