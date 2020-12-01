package com.quakec.model;

import java.util.UUID;

public class Approval {
	public final String alternativeId;
	public final String memberName;
	boolean isApproval;
	public final String id;
	
	public Approval(String alternativeId, String memberName, boolean isApproval, String id) {
		this.alternativeId = alternativeId;
		this.memberName = memberName;
		this.isApproval =  isApproval;
		this.id =  id;
	}
	
	public Approval(String alternativeId, String memberName, boolean isApproval) {
		this(alternativeId,memberName,isApproval,UUID.randomUUID().toString());
	}
	
	public String getAlternativeId() {return alternativeId;}
	
	public String getMemberName() {return memberName;}
	
	
	public void setApproval(boolean isApproval) {
		this.isApproval = isApproval;
	}
	public boolean isApproval() {return isApproval;}
	
	public String getId()  {return id;}
	
	
}
