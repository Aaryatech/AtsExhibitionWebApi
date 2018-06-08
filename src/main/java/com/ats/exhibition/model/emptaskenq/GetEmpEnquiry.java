package com.ats.exhibition.model.emptaskenq;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetEmpEnquiry implements Serializable {
	
	@Id
	private int enqId;
	
	private int empId;
	
	private String visitorName;
	
	private String visitorEmail;
	
	private String visitorMobile;
	
	private String eventName;
	
	private String empName;
	
	private String approximateTime;
	
	private int status;
	
	private Date nextMeetDate;
	
	public int getEnqId() {
		return enqId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public String getVisitorEmail() {
		return visitorEmail;
	}

	public String getVisitorMobile() {
		return visitorMobile;
	}

	public String getEventName() {
		return eventName;
	}

	public String getEmpName() {
		return empName;
	}

	public String getApproximateTime() {
		return approximateTime;
	}

	public int getStatus() {
		return status;
	}

	public void setEnqId(int enqId) {
		this.enqId = enqId;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public void setVisitorEmail(String visitorEmail) {
		this.visitorEmail = visitorEmail;
	}

	public void setVisitorMobile(String visitorMobile) {
		this.visitorMobile = visitorMobile;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setApproximateTime(String approximateTime) {
		this.approximateTime = approximateTime;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getNextMeetDate() {
		return nextMeetDate;
	}

	public void setNextMeetDate(Date nextMeetDate) {
		this.nextMeetDate = nextMeetDate;
	}

	@Override
	public String toString() {
		return "GetEmpEnquiry [enqId=" + enqId + ", empId=" + empId + ", visitorName=" + visitorName + ", visitorEmail="
				+ visitorEmail + ", visitorMobile=" + visitorMobile + ", eventName=" + eventName + ", empName="
				+ empName + ", approximateTime=" + approximateTime + ", status=" + status + ", nextMeetDate="
				+ nextMeetDate + "]";
	}

}
