package com.ats.exhibition.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetEnqList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enq_id")
	private int enqId;

	@Column(name = "visitor_id")
	private int visitorId;

	private String visitorName;

	@Column(name = "exh_id")
	private int exhId;

	private String exhName;

	@Column(name = "event_id")
	private int eventId;

	private String eventName;

	@Column(name = "emp_id")
	private int empId;

	private String empName;

	@Column(name = "date")
	private Date date;

	@Column(name = "next_meet_date")
	private Date nextMeetDate;

	@Column(name = "approximate_time")
	private String approximateTime;

	@Column(name = "remark")
	private String remark;

	@Column(name = "status")
	private int status;

	@Column(name = "is_used")
	private int isUsed;

	public int getEnqId() {
		return enqId;
	}

	public void setEnqId(int enqId) {
		this.enqId = enqId;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	public String getExhName() {
		return exhName;
	}

	public void setExhName(String exhName) {
		this.exhName = exhName;
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

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy HH:mm:ss")
	
	public String getRemark() {
		return remark;
	}
   
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
	
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}
	
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getNextMeetDate() {
		return nextMeetDate;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setNextMeetDate(Date nextMeetDate) {
		this.nextMeetDate = nextMeetDate;
	}
	
	public String getApproximateTime() {
		return approximateTime;
	}

	public void setApproximateTime(String approximateTime) {
		this.approximateTime = approximateTime;
	}

	@Override
	public String toString() {
		return "GetEnqList [enqId=" + enqId + ", visitorId=" + visitorId + ", visitorName=" + visitorName + ", exhId="
				+ exhId + ", exhName=" + exhName + ", eventId=" + eventId + ", eventName=" + eventName + ", empId="
				+ empId + ", empName=" + empName + ", date=" + date + ", nextMeetDate=" + nextMeetDate
				+ ", approximateTime=" + approximateTime + ", remark=" + remark + ", status=" + status + ", isUsed="
				+ isUsed + "]";
	}
	
	
}
