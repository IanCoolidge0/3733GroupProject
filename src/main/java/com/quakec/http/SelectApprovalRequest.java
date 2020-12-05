package com.quakec.http;

public class SelectApprovalRequest {
	String name;
	String alternativeId;
	String memberId;
	
	public SelectApprovalRequest(String name, String alternativeId, String memberId) {
		this.name = name;
		this.alternativeId = alternativeId;
		this.memberId = memberId;
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

	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
