package com.quakec.model;

import java.util.UUID;

public class Member {
	public String id;
	public String choiceId;
	public String name;
	public String password;
	public boolean hasPassword;
	
	public Member() {
		
	}
	
	public Member(String choiceId,String name, String password) {
		this.id = UUID.randomUUID().toString();
		this.choiceId = choiceId;
		this.name = name;
		if(password.equals("")) {
			this.hasPassword = false;
			this.password = "";
		} else {
			this.hasPassword = true;
			this.password  = password;
		}	
	}
	
	public Member(String id, String choiceId, String name, String password, boolean hasPassword) {	
		this.id = id;
		this.choiceId = choiceId;
		this.name = name;
		this.password = password;
		this.hasPassword = hasPassword;	
	}
	
	public String getId() {return id;}
	
	public String getChoiceId() {return  choiceId;}
	
	public String getName() {return name;}
	
	public String getPassword() {return password;}
	
	public boolean getHasPassword() {return hasPassword;}
	
	public void setId(String id) {this.id = id;}
	public void setChoiceId(String id) {this.choiceId = id;}
	public void setName(String name) {this.name = name;}
	public void setPassword(String password) {this.password = password;}
	public void setHasPassword(boolean hasPassword) {this.hasPassword = hasPassword;}
		
}
