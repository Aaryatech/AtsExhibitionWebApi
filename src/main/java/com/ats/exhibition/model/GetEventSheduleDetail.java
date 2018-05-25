package com.ats.exhibition.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
public class GetEventSheduleDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "schedule_detail_id")
	private int scheduleDetailId;

	@Column(name = "schedule_id")
	private int scheduleId;
	
	@Column(name = "topic")
	private String topic;

	@Column(name = "from_time")
	private String fromTime;
	
	@Column(name = "to_time")
	private String toTime;
	
	@Column(name = "venue")
	private String venue;

	@Column(name = "speaker")
	private String speaker;
	
	@Column(name = "remark")
	private String remark;

	@Column(name = "seats_available")
	private int seatsAvailable;
	
	@Column(name = "is_used")
	private int isUsed;

	public int getScheduleDetailId() {
		return scheduleDetailId;
	}

	public void setScheduleDetailId(int scheduleDetailId) {
		this.scheduleDetailId = scheduleDetailId;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "GetEventSheduleDetail [scheduleDetailId=" + scheduleDetailId + ", scheduleId=" + scheduleId + ", topic="
				+ topic + ", fromTime=" + fromTime + ", toTime=" + toTime + ", venue=" + venue + ", speaker=" + speaker
				+ ", remark=" + remark + ", seatsAvailable=" + seatsAvailable + ", isUsed=" + isUsed + "]";
	}
	
	
	

}
