package com.quakec.http;

public class ViewChoicesRequest {
	String choiceId;
	String memberId;
	
	public String getChoiceId() {return choiceId;}
	
	public void setChoiceId(String choiceId) {this.choiceId=choiceId;}
	
	public String getMemberId() {return memberId;}
	
	public void setMemberId(String memberId) {this.memberId=memberId;}
	
	public String toString() {
		String s = "ViewChoice( " + choiceId + ", " + memberId + ")";
		return s;
	}
	
	public ViewChoicesRequest() {
		
	}
	
	public ViewChoicesRequest(String choiceId, String memberId) {
		this.choiceId = choiceId;
		this.memberId = memberId;
	}
	
	

}
