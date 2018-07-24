package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductListWithCount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prod_id")
	private int prodId;

	@Column(name = "exh_id")
	private int exhId;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "prod_desc")
	private String prodDesc;

	@Column(name = "prod_specification")
	private String prodSpecification;

	@Column(name = "prod_experty")
	private String prodExperty;

	@Column(name = "prod_image1")
	private String prodImage1;

	@Column(name = "prod_image2")
	private String prodImage2;

	@Column(name = "prod_image3")
	private String prodImage3;

	@Column(name = "is_used")
	private int isUsed;
	
	@Column(name = "visit_count")
	private int visitCount;

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdSpecification() {
		return prodSpecification;
	}

	public void setProdSpecification(String prodSpecification) {
		this.prodSpecification = prodSpecification;
	}

	public String getProdExperty() {
		return prodExperty;
	}

	public void setProdExperty(String prodExperty) {
		this.prodExperty = prodExperty;
	}

	public String getProdImage1() {
		return prodImage1;
	}

	public void setProdImage1(String prodImage1) {
		this.prodImage1 = prodImage1;
	}

	public String getProdImage2() {
		return prodImage2;
	}

	public void setProdImage2(String prodImage2) {
		this.prodImage2 = prodImage2;
	}

	public String getProdImage3() {
		return prodImage3;
	}

	public void setProdImage3(String prodImage3) {
		this.prodImage3 = prodImage3;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	@Override
	public String toString() {
		return "ProductListWithCount [prodId=" + prodId + ", exhId=" + exhId + ", prodName=" + prodName + ", prodDesc="
				+ prodDesc + ", prodSpecification=" + prodSpecification + ", prodExperty=" + prodExperty
				+ ", prodImage1=" + prodImage1 + ", prodImage2=" + prodImage2 + ", prodImage3=" + prodImage3
				+ ", isUsed=" + isUsed + ", visitCount=" + visitCount + "]";
	}
	
	

}
