package com.quakec.http;

public class RegisterMemberRequest {
	String choiceId;
	String name;
	String password;

	
	public String getChoiceId() { return choiceId;}
	public void setChoiceId(String c) {this.choiceId = c;}
	
	public String getName() { return name;}
	public void setName(String n) {this.name = n;}
	
	public String getPassword() { return password;}
	public void setPassword(String p) {this.password = p;}
	
	public String toString() {
		return "Add(" + choiceId + "," + name + "," + password + ")";
	}
	
//	public RegisterMemberRequest(String choiceId, String name) {
//		this.choiceId = choiceId;
//		this.name = name;
//		this.password = "";
//	}
	
	public RegisterMemberRequest(String choiceId, String name, String password) {
		this.choiceId = choiceId;
		this.name = name;
		this.password = password;
	}
	
}
