package com.quakec.http;

public class ViewChoicesRequest {
	String id;
	
	public String getId() {return id;}
	
	public void setId(String id) {this.id=id;}
	
	public String toString() {
		String s = "ViewChoice( " + id;
		return s;
	}
	
	public ViewChoicesRequest() {
		
	}
	
	public ViewChoicesRequest(String id) {
		this.id = id;
	}
	
	

}
