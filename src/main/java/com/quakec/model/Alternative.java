package com.quakec.model;

import java.util.UUID;

public class Alternative {

	public final String id;
	public final String choiceId;
	public final String name;
	public final int number;
	

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
	
}
