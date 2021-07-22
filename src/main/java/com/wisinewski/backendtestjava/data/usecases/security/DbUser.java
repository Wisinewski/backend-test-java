package com.wisinewski.backendtestjava.data.usecases.security;

import org.springframework.security.core.context.SecurityContextHolder;

import com.wisinewski.backendtestjava.security.UserSS;

public class DbUser {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception exception) {
			return null;
		}
	}
	
}
