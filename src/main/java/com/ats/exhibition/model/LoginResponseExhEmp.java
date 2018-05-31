package com.ats.exhibition.model;

public class LoginResponseExhEmp {
	private boolean error;
	private String msg;
	private ExhEmployee exhEmployee;

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

	public ExhEmployee getExhEmployee() {
		return exhEmployee;
	}

	public void setExhEmployee(ExhEmployee exhEmployee) {
		this.exhEmployee = exhEmployee;
	}

	@Override
	public String toString() {
		return "LoginResponseExhEmp [error=" + error + ", msg=" + msg + ", exhEmployee=" + exhEmployee + "]";
	}

}
