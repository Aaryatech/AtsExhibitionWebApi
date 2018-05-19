package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_visitor_product")
public class VisitorProductMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "visitor_product_id")
	private int visitorProductId;

	@Column(name = "visitor_id")
	private int visitorId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "exhibitor_id")
	private int exhibitorId;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "like_status")
	private int likeStatus;

	public int getVisitorProductId() {
		return visitorProductId;
	}

	public void setVisitorProductId(int visitorProductId) {
		this.visitorProductId = visitorProductId;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getExhibitorId() {
		return exhibitorId;
	}

	public void setExhibitorId(int exhibitorId) {
		this.exhibitorId = exhibitorId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getLikeStatus() {
		return likeStatus;
	}

	public void setLikeStatus(int likeStatus) {
		this.likeStatus = likeStatus;
	}

	@Override
	public String toString() {
		return "VisitorProductMapping [visitorProductId=" + visitorProductId + ", visitorId=" + visitorId + ", eventId="
				+ eventId + ", exhibitorId=" + exhibitorId + ", productId=" + productId + ", likeStatus=" + likeStatus
				+ "]";
	}

}
