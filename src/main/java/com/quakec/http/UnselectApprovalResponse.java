package com.quakec.http;

public class UnselectApprovalResponse {

	public int statusCode;
	public String error;
	
	public UnselectApprovalResponse(int statusCode) {
		this(statusCode, "");
	}
	
	public UnselectApprovalResponse(int statusCode, String errorMsg) {
		this.statusCode = statusCode;
		error = errorMsg;
	}
	
	public String toString() {
		if(statusCode / 100 == 2) {
			return "success";
		} else {
			return "ErrorResult(" + statusCode + ", err=" + error + ")";
		}
	}
	
}
