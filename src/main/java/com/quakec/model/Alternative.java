package com.quakec.model;

import java.util.UUID;

public class Alternative {

	public final String name;
	public final String id;
	public final int number;
	
	public Alternative(String name, String id, int number) {
		this.name = name;
		this.id = id;
		this.number = number;
	}
	
	public Alternative(String name, int number) {
		this(name, UUID.randomUUID().toString(), number);
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
	
}
