package com.quakec.http;

public class RegisterMemberRequest {
	String arg1;
	String arg2;
	String arg3;

	
	public String getArg1() { return arg1;}
	public void setArg1(String a) {this.arg1 = a;}
	
	public String getArg2() { return arg2;}
	public void setArg2(String a) {this.arg2 = a;}
	
	public String getArg3() { return arg3;}
	public void setArg3(String a) {this.arg3 = a;}
	
	public String toString() {
		return "Add(" + arg1 + "," + arg2 + "," + arg3 + ")";
	}
	
	public RegisterMemberRequest(String arg1, String arg2) {
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = "";
	}
	
	public RegisterMemberRequest(String arg1, String arg2, String arg3) {
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
	}
	
}
