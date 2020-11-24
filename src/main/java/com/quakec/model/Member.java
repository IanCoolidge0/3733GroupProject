package com.quakec.model;


public class Member {
	public final String name;
	public final String password;
	public final boolean hasPassword;
	public boolean registered;
	
	
	
	public Member(String n, String p) {
		this.name = n;
		this.registered = false;
		if(p.equals("")) {
			this.hasPassword = false;
			this.password = "";
		} else {
			this.hasPassword = true;
			this.password  = p;
		}
		
	}
	
	public Member(String n, String p, boolean h, boolean r) {
		this.name = n;
		this.password = p;
		this.hasPassword = h;
		this.registered = r;
	}
	
	
	
	
	
	public String getName() {return name;}

	
	public String getPassword() {return password;}
	
	public boolean getHasPassword() {return hasPassword;}
	
	
	public boolean getRegistered() {return registered;}
	public void setRegistered(boolean r) {this.registered = r;}
	
	

}
