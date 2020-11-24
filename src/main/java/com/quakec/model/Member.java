package com.quakec.model;

import java.util.UUID;

public class Member {
	public final String name;
	public final String id;
	public final String password;
	public final boolean hasPassword;
	public boolean registered;
	
	
	
	public Member(String n, String p) {
		this.name = n;
		this.id = UUID.fromString("name:"+name).toString(); 
		this.registered = false;
		if(p.equals("")) {
			this.hasPassword = false;
			this.password = "";
		} else {
			this.hasPassword = true;
			this.password  = p;
		}
		
	}
	
	
	
	public String getName() {return name;}
	
	public String getId() {return id;}
	
	public String getPassword() {return password;}
	
	public boolean getHasPassword() {return hasPassword;}
	
	
	public boolean getRegistered() {return registered;}
	public void setRegistered(boolean r) {this.registered = r;}
	
	

}
