package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_mkt_material")
public class MktMaterial {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mat_id")
	private int matId;

	@Column(name = "mat_name")
	private String matName;

	@Column(name = "mat_link")
	private String matLink;

	@Column(name = "is_used")
	private int isUsed;

	public int getMatId() {
		return matId;
	}

	public void setMatId(int matId) {
		this.matId = matId;
	}

	public String getMatName() {
		return matName;
	}

	public void setMatName(String matName) {
		this.matName = matName;
	}

	public String getMatLink() {
		return matLink;
	}

	public void setMatLink(String matLink) {
		this.matLink = matLink;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "MktMaterial [matId=" + matId + ", matName=" + matName + ", matLink=" + matLink + ", isUsed=" + isUsed
				+ "]";
	}

}
