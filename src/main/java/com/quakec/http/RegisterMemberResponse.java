package com.quakec.http;

public class RegisterMemberResponse {
	public final String response;
	public final int httpCode;
			
	public RegisterMemberResponse (String s, int c) {
		this.response = s;
		this.httpCode = c;
	}
	
	public RegisterMemberResponse (String s) {
		this.response = s;
		this.httpCode = 200;
	}
	
	public String toString() {
		return "Response(" + response + ")";
	}
}



