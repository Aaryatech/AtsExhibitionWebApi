package com.ats.exhibition.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetSchedule implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduleId;
	
	private int eventId;
	
	private String eventName;

	private Date date;
	
	private String dayName;
	
	private int isUsed;
	
	@Transient
	List<ScheduleDetail>  scheduleDetailList;
	
	

	public List<ScheduleDetail> getScheduleDetailList() {
		return scheduleDetailList;
	}

	public void setScheduleDetailList(List<ScheduleDetail> scheduleDetailList) {
		this.scheduleDetailList = scheduleDetailList;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public int getEventId() {
		return eventId;
	}

	public String getEventName() {
		return eventName;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public String getDayName() {
		return dayName;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "GetSchedule [scheduleId=" + scheduleId + ", eventId=" + eventId + ", eventName=" + eventName + ", date="
				+ date + ", dayName=" + dayName + ", isUsed=" + isUsed + "]";
	}

	
}
