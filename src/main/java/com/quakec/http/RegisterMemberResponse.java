package com.quakec.http;

public class RegisterMemberResponse {
	public final String response;
	public final int httpCode;
	
	public String memberId;
			
	public RegisterMemberResponse (String s, int c, String m) {
		this.response = s;
		this.httpCode = c;
		this.memberId = m;
	}
	
	public RegisterMemberResponse (String s, String m) {
		this.response = s;
		this.httpCode = 200;
		this.memberId = m;
	}
	
	public RegisterMemberResponse(String s, int c) {
		this.response = s;
		this.httpCode = c;
		this.memberId = "";
	}
	
	public String toString() {
		return "Response(" + response + ")";
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}



