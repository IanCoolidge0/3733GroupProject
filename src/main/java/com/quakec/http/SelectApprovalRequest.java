package com.quakec.http;

public class SelectApprovalRequest {
	String name;
	String alternativeId;
	
	public SelectApprovalRequest(String name, String alternativeId) {
		this.name = name;
		this.alternativeId = alternativeId;
	}
	
	public SelectApprovalRequest() {
		
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
}
