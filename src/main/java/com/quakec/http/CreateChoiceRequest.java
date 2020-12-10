package com.quakec.http;

import java.util.List;

public class CreateChoiceRequest {
	String title;
	String description;
	int memberCount;
	List<String> alternatives;
	String id;
	
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
	
	public int getMemberCount() {
		return memberCount;
	}
	
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	public List<String> getAlternatives() {
		return alternatives;
	}
	
	public void setAlternatives(List<String> alternatives) {
		this.alternatives = alternatives;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		String s = "CreateChoice(" + title + "," + description + "," + memberCount + ",";
		for(int i = 0; i < alternatives.size() - 1; i++) s += alternatives.get(i) + ",";
		s += alternatives.get(alternatives.size() - 1) + ")";
		s += ", " + id;
		return s;
	}
	
	public CreateChoiceRequest(String title, String description, int memberCount, List<String> alternatives, String id) {
		this.title = title;
		this.description = description;
		this.memberCount = memberCount;
		this.alternatives = alternatives;
		this.id = id;
	}
	
	public CreateChoiceRequest() {
		
	}
}
