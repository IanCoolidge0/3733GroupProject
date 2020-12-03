package com.quakec.model;

import java.util.Date;
import java.util.UUID;

public class Feedback {
	public final String id;
	public final String alternativeId;
	public final String memberId;
	public final String memberName;
	public final String contents;
	public final Date datetime;
	
	
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
		
}
