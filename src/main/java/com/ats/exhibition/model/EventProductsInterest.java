package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_event_products_interest")
public class EventProductsInterest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tr_id")
	private int trId;

	@Column(name = "event_id")
	private int eventId;

	@Column(name = "exh_id")
	private int exhId;

	@Column(name = "prod_id")
	private int prodId;

	@Column(name = "visitor_id")
	private int visitorId;

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

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
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
		return "EventProductsInterest [trId=" + trId + ", eventId=" + eventId + ", exhId=" + exhId + ", prodId="
				+ prodId + ", visitorId=" + visitorId + ", productRating=" + productRating + ", productRemark="
				+ productRemark + ", isUsed=" + isUsed + "]";
	}

}
