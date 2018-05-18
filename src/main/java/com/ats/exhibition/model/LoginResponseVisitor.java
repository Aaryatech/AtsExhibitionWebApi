package com.ats.exhibition.model;

public class LoginResponseVisitor {
	private boolean error;
	private String msg;
	private Visitor visitor;
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
	public Visitor getVisitor() {
		return visitor;
	}
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	@Override
	public String toString() {
		return "LoginResponseVisitor [error=" + error + ", msg=" + msg + ", visitor=" + visitor + "]";
	}
	
	
}
