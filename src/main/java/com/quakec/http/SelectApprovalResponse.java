package com.quakec.http;

public class SelectApprovalResponse {

	public int statusCode;
	public String error;
	
	public SelectApprovalResponse(int statusCode) {
		this(statusCode, "");
	}
	
	public SelectApprovalResponse(int statusCode, String errorMsg) {
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
