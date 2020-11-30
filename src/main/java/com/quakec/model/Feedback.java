package com.quakec.model;

import java.util.Date;
import java.util.UUID;

public class Feedback {
	public final String contents;
	public final String memberName;
	public final String alternativeId;
	public final Date datetime;
	public final String id;
	
	public Feedback(String contents,String memberName, String alternativeId, Date datetime, String id) {
		this.contents =  contents;
		this.memberName = memberName;
		this.alternativeId = alternativeId;
		this.datetime = datetime;
		this.id = id;
	}
	
	public Feedback(String contents, String memberName, String alternativeId) {
		this(contents,memberName,alternativeId,new Date(),UUID.randomUUID().toString());
	}
	
	public String getContents() {return contents;}
	
	public String getMemberName() {return memberName;}
	
	public String getAlternativeId() {return alternativeId;}
	
	public Date getDatetime() {return datetime;}
	
	public String getId() {return id;}
}
