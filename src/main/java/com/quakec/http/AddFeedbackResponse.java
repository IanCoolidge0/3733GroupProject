package com.quakec.http;

public class AddFeedbackResponse {

	public int statusCode;
	public String error;
	
	public AddFeedbackResponse(int statusCode) {
		this(statusCode, "");
	}
	
	public AddFeedbackResponse(int statusCode, String errorMsg) {
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
