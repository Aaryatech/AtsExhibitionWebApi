package com.ats.exhibition.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
public class GetEventSheduleHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "schedule_id")
	private int scheduleId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "date")
	private Date date;

	@Column(name = "day_name")
	private String dayName;

	@Column(name = "is_used")
	private int isUsed;
	
	@Transient
	List<GetEventSheduleDetail> getEventSheduleDetailList;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public List<GetEventSheduleDetail> getGetEventSheduleDetailList() {
		return getEventSheduleDetailList;
	}

	public void setGetEventSheduleDetailList(List<GetEventSheduleDetail> getEventSheduleDetailList) {
		this.getEventSheduleDetailList = getEventSheduleDetailList;
	}

	@Override
	public String toString() {
		return "GetEventSheduleHeader [scheduleId=" + scheduleId + ", eventId=" + eventId + ", date=" + date
				+ ", dayName=" + dayName + ", isUsed=" + isUsed + ", getEventSheduleDetailList="
				+ getEventSheduleDetailList + "]";
	} 
	
	

}
