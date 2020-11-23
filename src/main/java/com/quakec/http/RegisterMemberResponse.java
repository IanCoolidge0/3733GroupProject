package com.quakec.http;

public class RegisterMemberResponse {
	public int statusCode;
	public String error;
	
	public RegisterMemberResponse (int statusCode) {
		this.statusCode = statusCode;
		this.error = "";
	}
	
	public RegisterMemberResponse (int statusCode, String errorMessage) {
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
