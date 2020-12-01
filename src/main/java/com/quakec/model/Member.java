package com.quakec.model;


public class Member {
	public final String name;
	public final String password;
	public final boolean hasPassword;
	public boolean isRegistered;
	public final String choiceId;
	
	
	
	public Member(String choiceId,String name, String password) {
		this.name = name;
		this.isRegistered = false;
		this.choiceId = choiceId;
		if(password.equals("")) {
			this.hasPassword = false;
			this.password = "";
		} else {
			this.hasPassword = true;
			this.password  = password;
		}
		
	}
	
	public Member(String name, String password, boolean hasPassword, boolean isRegistered, String choiceId) {
		this.name = name;
		this.password = password;
		this.hasPassword = hasPassword;
		this.isRegistered = isRegistered;
		this.choiceId = choiceId;
	}
	
	
	public String getName() {return name;}
	
	public String getPassword() {return password;}
	
	public boolean getHasPassword() {return hasPassword;}
	
	
	public boolean getRegistered() {return isRegistered;}
	public void setRegistered(boolean isRegistered) {this.isRegistered = isRegistered;}
	
	public String getChoiceId() {return  choiceId;}
	
	

}
