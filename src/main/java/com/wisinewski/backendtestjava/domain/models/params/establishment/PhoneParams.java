package com.wisinewski.backendtestjava.domain.models.params.establishment;

public class PhoneParams {

	private String ddd;
	private String phoneNumber;
	
	public PhoneParams(String ddd, String phoneNumber) {
		this.ddd = ddd;
		this.phoneNumber = phoneNumber;
	}

	public String getDdd() {
		return ddd;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
}
