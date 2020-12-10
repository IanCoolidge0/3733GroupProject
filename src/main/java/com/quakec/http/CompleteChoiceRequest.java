package com.quakec.http;

public class CompleteChoiceRequest {
	String choiceId;
	String alternativeId;
	
	public CompleteChoiceRequest() {
		
	}
	
	public CompleteChoiceRequest(String choiceId, String alternativeId) {
		this.choiceId = choiceId;
		this.alternativeId = alternativeId;
	}

	public String getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(String choiceId) {
		this.choiceId = choiceId;
	}

	public String getAlternativeId() {
		return alternativeId;
	}

	public void setAlternativeId(String alternativeId) {
		this.alternativeId = alternativeId;
	}
	
}
