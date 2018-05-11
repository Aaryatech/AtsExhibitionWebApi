
package com.ats.exhibition.model;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "m_events")

public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "event_id")
	private int eventId;

	@Column(name = "org_id")
	private int orgId;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_from_date")
	private String eventFromDate;

	@Column(name = "event_to_date")
	private String eventToDate;

	@Column(name = "from_time")
	private String fromTime;

	@Column(name = "to_time")
	private String toTime;

	@Column(name = "event_location")
	private String eventLocation;

	@Column(name = "event_loc_lat")
	private String eventLocLat;

	@Column(name = "event_loc_long")
	private String eventLocLong;

	@Column(name = "about_event")
	private String aboutEvent;

	@Column(name = "event_logo")
	private String eventLogo;

	@Column(name = "contact_person_name1")
	private String contactPersonName1;

	@Column(name = "contact_person_name2")
	private String contactPersonName2;

	@Column(name = "person1_mob")
	private String person1Mob;

	@Column(name = "person2_mob")
	private String person2Mob;

	@Column(name = "person1_email_id")
	private String person1EmailId;

	@Column(name = "person2_email_id")
	private String person2EmailId;

	@Column(name = "is_used")
	private int isUsed;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventFromDate() {
		return eventFromDate;
	}

	public void setEventFromDate(String eventFromDate) {
		this.eventFromDate = eventFromDate;
	}

	public String getEventToDate() {
		return eventToDate;
	}

	public void setEventToDate(String eventToDate) {
		this.eventToDate = eventToDate;
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

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public String getEventLocLat() {
		return eventLocLat;
	}

	public void setEventLocLat(String eventLocLat) {
		this.eventLocLat = eventLocLat;
	}

	public String getEventLocLong() {
		return eventLocLong;
	}

	public void setEventLocLong(String eventLocLong) {
		this.eventLocLong = eventLocLong;
	}

	public String getAboutEvent() {
		return aboutEvent;
	}

	public void setAboutEvent(String aboutEvent) {
		this.aboutEvent = aboutEvent;
	}

	public String getEventLogo() {
		return eventLogo;
	}

	public void setEventLogo(String eventLogo) {
		this.eventLogo = eventLogo;
	}

	public String getContactPersonName1() {
		return contactPersonName1;
	}

	public void setContactPersonName1(String contactPersonName1) {
		this.contactPersonName1 = contactPersonName1;
	}

	public String getContactPersonName2() {
		return contactPersonName2;
	}

	public void setContactPersonName2(String contactPersonName2) {
		this.contactPersonName2 = contactPersonName2;
	}

	public String getPerson1Mob() {
		return person1Mob;
	}

	public void setPerson1Mob(String person1Mob) {
		this.person1Mob = person1Mob;
	}

	public String getPerson2Mob() {
		return person2Mob;
	}

	public void setPerson2Mob(String person2Mob) {
		this.person2Mob = person2Mob;
	}

	public String getPerson1EmailId() {
		return person1EmailId;
	}

	public void setPerson1EmailId(String person1EmailId) {
		this.person1EmailId = person1EmailId;
	}

	public String getPerson2EmailId() {
		return person2EmailId;
	}

	public void setPerson2EmailId(String person2EmailId) {
		this.person2EmailId = person2EmailId;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "Events [eventId=" + eventId + ", orgId=" + orgId + ", eventName=" + eventName + ", eventFromDate="
				+ eventFromDate + ", eventToDate=" + eventToDate + ", fromTime=" + fromTime + ", toTime=" + toTime
				+ ", eventLocation=" + eventLocation + ", eventLocLat=" + eventLocLat + ", eventLocLong=" + eventLocLong
				+ ", aboutEvent=" + aboutEvent + ", eventLogo=" + eventLogo + ", contactPersonName1="
				+ contactPersonName1 + ", contactPersonName2=" + contactPersonName2 + ", person1Mob=" + person1Mob
				+ ", person2Mob=" + person2Mob + ", person1EmailId=" + person1EmailId + ", person2EmailId="
				+ person2EmailId + ", isUsed=" + isUsed + "]";
	}

	
}
