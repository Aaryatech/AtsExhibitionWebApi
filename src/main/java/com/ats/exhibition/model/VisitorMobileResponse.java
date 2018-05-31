package com.ats.exhibition.model;

public class VisitorMobileResponse {

	private boolean error;
	private String msg;
	private VisitorWithOrgEventName visitorWithOrgEventName;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public VisitorWithOrgEventName getVisitorWithOrgEventName() {
		return visitorWithOrgEventName;
	}

	public void setVisitorWithOrgEventName(VisitorWithOrgEventName visitorWithOrgEventName) {
		this.visitorWithOrgEventName = visitorWithOrgEventName;
	}

	@Override
	public String toString() {
		return "VisitorMobileResponse [error=" + error + ", msg=" + msg + ", visitorWithOrgEventName="
				+ visitorWithOrgEventName + "]";
	}

}
