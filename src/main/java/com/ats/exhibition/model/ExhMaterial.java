package com.ats.exhibition.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_exh_material")
public class ExhMaterial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tr_id")
	private int trId;

	@Column(name = "exh_id")
	private int exhId;

	@Column(name = "mat_name")
	private String matName;

	@Column(name = "mat_link")
	private String matLink;

	@Column(name = "is_used")
	private int isUsed;

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
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
		return "ExhMaterial [trId=" + trId + ", exhId=" + exhId + ", matName=" + matName + ", matLink=" + matLink
				+ ", isUsed=" + isUsed + "]";
	}

}
