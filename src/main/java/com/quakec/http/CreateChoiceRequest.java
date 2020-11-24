package com.quakec.http;

public class CreateChoiceRequest {
	String title;
	String description;
	String[] alternatives;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getAlternatives() {
		return alternatives;
	}

	public String toString() {
		String s = "CreateChoice(" + title + "," + description + ",";
		for(int i = 0; i < alternatives.length - 1; i++) s += alternatives[i] + ",";
		s += alternatives[alternatives.length - 1] + ")";
		return s;
	}
	
	public CreateChoiceRequest(String title, String description, String[] alternatives) {
		this.title = title;
		this.description = description;
		this.alternatives = alternatives;
	}
}
