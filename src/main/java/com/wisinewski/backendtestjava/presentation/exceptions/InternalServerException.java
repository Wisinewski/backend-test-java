package com.wisinewski.backendtestjava.presentation.exceptions;

public class InternalServerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InternalServerException() {
		super("Internal server error");
	}

}
