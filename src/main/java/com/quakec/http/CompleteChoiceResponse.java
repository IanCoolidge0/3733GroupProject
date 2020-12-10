package com.quakec.http;

public class CompleteChoiceResponse {

	public int statusCode;
	public String error;
	
	public CompleteChoiceResponse (int statusCode) {
		this.statusCode = statusCode;
		this.error = "";
	}
	
	public CompleteChoiceResponse (int statusCode, String errorMessage) {
		this.statusCode = statusCode;
		this.error = errorMessage;
	}
	
	public String toString() {
		if (statusCode / 100 == 2) {  // too cute?
			return "It worked!";
		} else {
			return "ErrorResult(" + statusCode + ", err=" + error + ")";
		}
	}

}
