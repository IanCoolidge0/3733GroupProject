package com.quakec.http;

import java.util.List;

public class CreateChoiceRequest {
	String title;
	String description;
	List<String> alternatives;
	
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

	public List<String> getAlternatives() {
		return alternatives;
	}
	
	public void setAlternatives(List<String> alternatives) {
		this.alternatives = alternatives;
	}

	public String toString() {
		String s = "CreateChoice(" + title + "," + description + ",";
		if(alternatives == null) return s;
		for(int i = 0; i < alternatives.size() - 1; i++) s += alternatives.get(i) + ",";
		s += alternatives.get(alternatives.size() - 1) + ")";
		return s;
	}
	
	public CreateChoiceRequest(String title, String description, List<String> alternatives) {
		this.title = title;
		this.description = description;
		this.alternatives = alternatives;
	}
	
	public CreateChoiceRequest() {
		
	}
}
