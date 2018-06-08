package com.ats.exhibition.model.emptaskenq;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetEmpTask  implements Serializable {
	@Id
	private int  taskId;
	
	private Date date;
	
	private String empName;
	
	private int status;
	
	private int empId;
	
	private String taskDesc;

	public int getTaskId() {
		return taskId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDate() {
		return date;
	}

	public String getEmpName() {
		return empName;
	}

	public int getStatus() {
		return status;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	@Override
	public String toString() {
		return "GetEmpTask [taskId=" + taskId + ", date=" + date + ", empName=" + empName + ", status=" + status
				+ ", empId=" + empId + ", taskDesc=" + taskDesc + "]";
	}
	
	
}
