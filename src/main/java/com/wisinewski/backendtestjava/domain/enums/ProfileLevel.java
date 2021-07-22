package com.wisinewski.backendtestjava.domain.enums;

public enum ProfileLevel {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENT(2, "ROLE_CLIENT");
	
	private int code;
	private String description;
	
	private ProfileLevel(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static ProfileLevel toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		for(ProfileLevel profile : ProfileLevel.values()) {
			if(code.equals(profile.getCode())) {
				return profile;
			}
		}
		throw new IllegalArgumentException();
	}
	
}
