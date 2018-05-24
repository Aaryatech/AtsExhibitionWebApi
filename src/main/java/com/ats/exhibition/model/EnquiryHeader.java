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

@Entity
@Table(name = "m_enquiry_header")
public class EnquiryHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enq_id")
	private int enqId;

	@Column(name = "visitor_id")
	private int visitorId;

	@Column(name = "exh_id")
	private int exhId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "emp_id")
	private int empId;

	@Column(name = "date")
	private Date date;

	@Column(name = "next_meet_date")
	private Date nextMeetDate;

	@Column(name = "approximate_time")
	private String approximate_time;

	@Column(name = "remark")
	private String remark;

	@Column(name = "status")
	private int status;

	@Column(name = "is_used")
	private int isUsed;

	@Transient
	List<EnquiryDetail> enquiryDetailList;

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

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getNextMeetDate() {
		return nextMeetDate;
	}

	public void setNextMeetDate(Date nextMeetDate) {
		this.nextMeetDate = nextMeetDate;
	}

	public String getApproximate_time() {
		return approximate_time;
	}

	public void setApproximate_time(String approximate_time) {
		this.approximate_time = approximate_time;
	}

	public String getRemark() {
		return remark;
	}

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

	public List<EnquiryDetail> getEnquiryDetailList() {
		return enquiryDetailList;
	}

	public void setEnquiryDetailList(List<EnquiryDetail> enquiryDetailList) {
		this.enquiryDetailList = enquiryDetailList;
	}

	@Override
	public String toString() {
		return "EnquiryHeader [enqId=" + enqId + ", visitorId=" + visitorId + ", exhId=" + exhId + ", eventId="
				+ eventId + ", empId=" + empId + ", date=" + date + ", nextMeetDate=" + nextMeetDate
				+ ", approximate_time=" + approximate_time + ", remark=" + remark + ", status=" + status + ", isUsed="
				+ isUsed + ", enquiryDetailList=" + enquiryDetailList + "]";
	}

}
