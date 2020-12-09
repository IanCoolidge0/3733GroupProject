package com.quakec.http;

public class AddFeedbackRequest {
	String name;
	String alternativeId;
	String memberId;
	String feedback;
	
	public AddFeedbackRequest() {
		
	}

	public AddFeedbackRequest(String name, String alternativeId, String memberId, String feedback) {
		this.name = name;
		this.alternativeId = alternativeId;
		this.memberId = memberId;
		this.feedback = feedback;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlternativeId() {
		return alternativeId;
	}

	public void setAlternativeId(String alternativeId) {
		this.alternativeId = alternativeId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
