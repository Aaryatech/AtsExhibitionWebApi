package com.ats.exhibition.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_enquiry_detail")
public class EnquiryDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enq_detail_id")
	private int enqDetailId;

	@Column(name = "enq_id")
	private int enqId;

	@Column(name = "emp_id")
	private int empId;

	@Column(name = "date")
	private Date date;

	@Column(name = "venue")
	private String venue;

	@Column(name = "approximate_time")
	private String approximateTime;

	@Column(name = "remark")
	private String remark;

	@Column(name = "status")
	private int status;

	@Column(name = "is_used")
	private int isUsed;

	public int getEnqDetailId() {
		return enqDetailId;
	}

	public void setEnqDetailId(int enqDetailId) {
		this.enqDetailId = enqDetailId;
	}

	public int getEnqId() {
		return enqId;
	}

	public void setEnqId(int enqId) {
		this.enqId = enqId;
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

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	
	public String getApproximateTime() {
		return approximateTime;
	}

	public void setApproximateTime(String approximateTime) {
		this.approximateTime = approximateTime;
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

	@Override
	public String toString() {
		return "EnquiryDetail [enqDetailId=" + enqDetailId + ", enqId=" + enqId + ", empId=" + empId + ", date=" + date
				+ ", venue=" + venue + ", approximateTime=" + approximateTime + ", remark=" + remark + ", status="
				+ status + ", isUsed=" + isUsed + "]";
	}
	
	

}
