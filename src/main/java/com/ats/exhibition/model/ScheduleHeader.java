package com.ats.exhibition.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="m_exh_schedule")
public class ScheduleHeader implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int scheduleId;
	
	private int eventId;

	private String date;
	
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

	public String getDate() {
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

	public void setDate(String date) {
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
		return "ScheduleHeader [scheduleId=" + scheduleId + ", eventId=" + eventId + ", date=" + date + ", dayName="
				+ dayName + ", isUsed=" + isUsed + "]";
	}
	
	
	

}
