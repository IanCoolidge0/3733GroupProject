package com.quakec.http;

public class RegisterMemberResponse {
	public final String response;
	public final int httpCode;
	
	public String memberId;
	public String choiceId;
			
	public RegisterMemberResponse (String s, int c, String m, String choiceId) {
		this.response = s;
		this.httpCode = c;
		this.memberId = m;
		this.choiceId = choiceId;
	}
	
	public RegisterMemberResponse (String s, String m, String choiceId) {
		this.response = s;
		this.httpCode = 200;
		this.memberId = m;
		this.choiceId= choiceId;
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
	
	public String getChoiceId() {
		return choiceId;
	}
	
	public void setChoiceId(String choiceId) {
		this.choiceId =  choiceId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}



