package com.quakec.model;

import java.util.UUID;

public class Alternative {

	public final String name;
	public final String id;
	public final int number;
	public final String choiceId;
	
	public Alternative(String name, String id, int number, String choiceId) {
		this.name = name;
		this.id = id;
		this.number = number;
		this.choiceId = choiceId;
	}
	
	public Alternative(String name, int number, String choiceId) {
		this(name, UUID.randomUUID().toString(), number, choiceId);
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}
	
	public String getChoiceId() {
		return choiceId;
	}
	
}
