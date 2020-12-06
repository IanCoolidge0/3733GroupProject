package com.quakec.model;

import java.util.UUID;

public class Approval {
	public String id;
	public String alternativeId;
	public String memberId;
	public String memberName;
	boolean isApproval;
	
	public Approval() {
		
	}
	

	public Approval(String alternativeId, String memberId, String memberName, boolean isApproval) {
		this(UUID.randomUUID().toString(),alternativeId,memberId,memberName,isApproval);
	}
	
	public Approval(String id, String alternativeId, String memberId, String memberName, boolean isApproval) {
		this.id =  id;
		this.alternativeId = alternativeId;
		this.memberId = memberId;
		this.memberName = memberName;
		this.isApproval =  isApproval;	
	}
	
	public String getId()  {return id;}
	
	public String getAlternativeId() {return alternativeId;}
	
	public String getMemberId() {return memberId;}
	
	public String getMemberName() {return memberName;}
	
	public boolean getIsApproval() {return isApproval;}
	public void setApproval(boolean isApproval) {this.isApproval = isApproval;}
	
	public void setId(String id) {this.id = id;}
	
	public void setAlternativeId(String id) {this.alternativeId = id;}
	
	public void setMemberId(String id) {this.memberId = id;}
	
	public void setMemberName(String name) {this.memberName = name;}
	
	public void setIsApproval(boolean isApproval) {this.isApproval = isApproval;} 

}
