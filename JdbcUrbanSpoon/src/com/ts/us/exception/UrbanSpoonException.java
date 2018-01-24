package com.ts.us.exception;

public class UrbanSpoonException extends Exception {
	private String message;
	
	public UrbanSpoonException(String message){
		this.message=message;
	}

	@Override
	public String toString() {
		return "UrbanSpoonException [message=" + message + "]";
	}
	
	

}
