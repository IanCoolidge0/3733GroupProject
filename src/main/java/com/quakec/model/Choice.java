package com.quakec.model;

import java.util.Date;


public class Choice {
	
	public final String id;
	public final String name;
	public final String description;
	public final Date datetime;
	public final int memberCount;
	public boolean hasChosenAlternative;
	
	
	public Choice(String id, String name, String description, int memberCount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.memberCount = memberCount;
		this.datetime = new Date();
		this.hasChosenAlternative = false; 
	}
	
	public Choice(String id, String name, String description, Date datetime, int memberCount, boolean hasChosenAlternative) {
		this.id = id; 
		this.name = name;
		this.description = description;
		this.datetime = datetime;
		this.memberCount = memberCount;
		this.hasChosenAlternative = hasChosenAlternative;	
	}
	
	public String getId() {return id;}

	public String getName() {return name;}
	
	public String getDescription() {return description;}
	
	public Date getDatetime() {return datetime;}
	
	public int getMemberCount() {return memberCount;}
	
	public boolean getHasChosenAlternative() {return hasChosenAlternative;}
	public void setHasChosenAlternative(boolean hasChosenAlternative) {this.hasChosenAlternative= hasChosenAlternative;}	

}





