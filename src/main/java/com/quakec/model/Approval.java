package com.quakec.model;

import java.util.UUID;

public class Approval {
	public final String id;
	public final String alternativeId;
	public final String memberId;
	public final String memberName;
	boolean isApproval;
	
	

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

}
