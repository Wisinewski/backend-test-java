package com.wisinewski.backendtestjava.presentation.exceptions;

public class CNPJInUseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CNPJInUseException() {
		super("The received cnpj is already in use");
	}

}
