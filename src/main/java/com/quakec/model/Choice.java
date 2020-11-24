package com.quakec.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Choice {
	public final String name;
	public final String description;
	public final Date datetime;
	public int memberCount;
	public boolean hasChosenAlternative;
	public final String id;
	
	public Choice(String n, String d, int m) {
		this.name = n;
		this.description = d;
		this.memberCount = m;
		this.datetime = new Date();
		this.hasChosenAlternative = false;
		this.id = UUID.randomUUID().toString(); 
	}
	
	
	public Choice(String n, String description, Date datetime, int m, boolean h, String i) {
		this.name = n;
		this.description = description;
		this.datetime = datetime;
		this.memberCount = m;
		this.hasChosenAlternative = h;
		this.id = i; 
	}
	


	public String getName() {return name;}
	
	public String getId() {return id;}
	
	public String getDescription() {return description;}
	
	public void setMemberCount(int m) { memberCount = m; }
	public int getMemberCount() {return memberCount;}
	
	public Date getDatetime() {return datetime;}
	
	
	
	public boolean getHasChosenAlternative() {return hasChosenAlternative;}
	public void setHasChosenAlternative(boolean h) {this.hasChosenAlternative= h;}
	
	

}





