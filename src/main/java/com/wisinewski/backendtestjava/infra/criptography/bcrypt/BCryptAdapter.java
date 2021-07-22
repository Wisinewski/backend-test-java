package com.wisinewski.backendtestjava.infra.criptography.bcrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.wisinewski.backendtestjava.data.protocols.Hasher;

@Component
public class BCryptAdapter implements Hasher {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public BCryptAdapter(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public String hash(String value) {
		return bCryptPasswordEncoder.encode(value);
	}

}
