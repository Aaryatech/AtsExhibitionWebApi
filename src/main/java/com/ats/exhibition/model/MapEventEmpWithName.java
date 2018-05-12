package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MapEventEmpWithName {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "map_id")
	private int mapId;

	@Column(name = "emp_id")
	private int empId;
	
	@Column(name = "emp_name")
	private String empName;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "event_name")
	private String eventName;
	
	@Column(name = "is_active")
	private int isActive;

	@Column(name = "is_used")
	private int isUsed;

	

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}
	
	@Override
	public String toString() {
		return "MapEventEmpWithName [mapId=" + mapId + ", empId=" + empId + ", empName=" + empName + ", eventId="
				+ eventId + ", eventName=" + eventName + ", isActive=" + isActive + ", isUsed=" + isUsed + "]";
	}

}
