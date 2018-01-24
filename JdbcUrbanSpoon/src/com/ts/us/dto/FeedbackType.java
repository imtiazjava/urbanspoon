package com.ts.us.dto;

public class FeedbackType {
	private int id;
	private String description;

	public FeedbackType(){
		System.out.println("**FeedbackType object is created..");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FeedbackType [id=" + id + ", description=" + description + "]";
	}
	
	

}
