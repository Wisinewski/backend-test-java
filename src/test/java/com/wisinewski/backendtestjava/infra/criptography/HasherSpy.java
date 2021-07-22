package com.wisinewski.backendtestjava.infra.criptography;

import com.wisinewski.backendtestjava.data.protocols.Hasher;

public class HasherSpy implements Hasher {
	
	private String value;
	private String result = "hashed_value";

	@Override
	public String hash(String value) {
		this.value = value;
		return result;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
}
