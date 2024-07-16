package com.example.demo.exception;


public class DataNotFoundException extends RuntimeException{
String message="data not found";

public String getMessage() {
	return message;
}

public DataNotFoundException(String message) {
	super();
	this.message = message;
}
public DataNotFoundException() {
	
}
}
