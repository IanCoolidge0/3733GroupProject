package com.quakec.model;

import java.util.Date;
import java.util.UUID;

public class Feedback {
	public String id;
	public String alternativeId;
	public String memberId;
	public String memberName;
	public String contents;
	public Date datetime;
	
	public Feedback() {
		
	}
	
	
	public Feedback(String alternativeId, String memberId, String memberName, String contents) {
		this(UUID.randomUUID().toString(),alternativeId,memberId,memberName,contents,new Date());
	}
	
	public Feedback(String id, String alternativeId, String memberId, String memberName, String contents, Date datetime) {
		this.id = id;
		this.alternativeId = alternativeId;
		this.memberId = memberId;
		this.memberName = memberName;
		this.contents =  contents;
		this.datetime = datetime;	
	}
	
	public String getId() {return id;}
	
	public String getAlternativeId() {return alternativeId;}
	
	public String getMemberId() {return memberId;}
	
	public String getMemberName() {return memberName;}
	
	public String getContents() {return contents;}
	
	public Date getDatetime() {return datetime;}
	
	public void setId(String id) {this.id = id;}
	public void setAlternativeId(String id) {this.alternativeId = id;}
	public void setMemberId(String id) {this.memberId = id;}
	public void setMemberName(String name) {this.memberName = name;}
	public void setContents(String contents) {this.contents = contents;}
	public void setDatetime(Date datetime) {this.datetime = datetime;}
		
}
