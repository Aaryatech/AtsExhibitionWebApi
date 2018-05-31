package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private int taskId;

	@Column(name = "exh_id")
	private int exhId;

	@Column(name = "emp_id")
	private int empId;

	@Column(name = "date")
	private String date;

	@Column(name = "task_desc")
	private String taskDesc;

	@Column(name = "remark")
	private String remark;

	@Column(name = "status")
	private int status;

	@Column(name = "is_used")
	private int isUsed;

	@Column(name = "task_completed_date")
	private String taskCompletedDate;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
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
	
	

	public String getTaskCompletedDate() {
		return taskCompletedDate;
	}

	public void setTaskCompletedDate(String taskCompletedDate) {
		this.taskCompletedDate = taskCompletedDate;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", exhId=" + exhId + ", empId=" + empId + ", date=" + date + ", taskDesc="
				+ taskDesc + ", remark=" + remark + ", status=" + status + ", isUsed=" + isUsed + ", taskCompletedDate="
				+ taskCompletedDate + "]";
	}

}
