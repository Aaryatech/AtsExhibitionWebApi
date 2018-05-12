package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventProductsInterestAllName {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tr_id")
	private int trId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "exh_id")
	private int exhId;

	@Column(name = "exh_name")
	private String exhName;

	@Column(name = "prod_id")
	private int prodId;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "visitor_id")
	private int visitorId;

	@Column(name = "visitor_name")
	private String visitorName;

	@Column(name = "product_rating")
	private float productRating;

	@Column(name = "product_remark")
	private String productRemark;

	@Column(name = "is_used")
	private int isUsed;

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
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

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
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

	public float getProductRating() {
		return productRating;
	}

	public void setProductRating(float productRating) {
		this.productRating = productRating;
	}

	public String getProductRemark() {
		return productRemark;
	}

	public void setProductRemark(String productRemark) {
		this.productRemark = productRemark;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "EventProductsInterestAllName [trId=" + trId + ", eventId=" + eventId + ", eventName=" + eventName
				+ ", exhId=" + exhId + ", exhName=" + exhName + ", prodId=" + prodId + ", prodName=" + prodName
				+ ", visitorId=" + visitorId + ", visitorName=" + visitorName + ", productRating=" + productRating
				+ ", productRemark=" + productRemark + ", isUsed=" + isUsed + "]";
	}

}
