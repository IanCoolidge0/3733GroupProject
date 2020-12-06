package com.quakec.model;

import java.util.UUID;

public class Alternative {

	public String id;
	public String choiceId;
	public String name;
	public int number;
	
	public Alternative() {
		
	}
	
	public Alternative(String choiceId,String name, int number) {
		this( UUID.randomUUID().toString(),choiceId,name, number);
	}
	
	public Alternative(String id, String choiceId, String name, int number) {
		this.id = id;
		this.choiceId = choiceId;
		this.name = name;
		this.number = number;	
	}
	
	public String getId() {return id;}
	
	public String getChoiceId() {return choiceId;}

	public String getName() {return name;}

	public int getNumber() {return number;}
	
	public void setId(String id) {this.id = id;}
	
	public void setChoiceId(String choiceId) {this.choiceId=choiceId;}

	public void setName(String name) {this.name = name;}

	public void setNumber(int number) {this.number = number;}
	
}
