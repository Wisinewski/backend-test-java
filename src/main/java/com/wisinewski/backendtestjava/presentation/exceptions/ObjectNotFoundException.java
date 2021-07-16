package com.wisinewski.backendtestjava.presentation.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException() {
		super("Object not found");
	}

}
