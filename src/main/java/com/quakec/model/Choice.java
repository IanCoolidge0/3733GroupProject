package com.quakec.model;

import java.util.Date;


public class Choice {
	
	public String id;
	public String name;
	public String description;
	public Date datetime;
	public int memberCount;
	public String chosenAlternative;
	
	public Choice() {
		
	}
	
	public Choice(String id, String name, String description, int memberCount) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.memberCount = memberCount;
		this.datetime = new Date();
		this.chosenAlternative = ""; 
	}
	
	public Choice(String id, String name, String description, Date datetime, int memberCount, String chosenAlternative) {
		this.id = id; 
		this.name = name;
		this.description = description;
		this.datetime = datetime;
		this.memberCount = memberCount;
		this.chosenAlternative = chosenAlternative;	
	}
	
	public String getId() {return id;}

	public String getName() {return name;}
	
	public String getDescription() {return description;}
	
	public Date getDatetime() {return datetime;}
	
	public int getMemberCount() {return memberCount;}
	
	public String getChosenAlternative() {return chosenAlternative;}
	
	public void setId(String id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setDescription(String description) {this.description = description;}
	public void setDatetime(Date datetime) {this.datetime = datetime;}
	public void setMemberCount(int memberCount) {this.memberCount = memberCount;}
	public void setChosenAlternative(String chosenAlternative) {this.chosenAlternative= chosenAlternative;}	

}





