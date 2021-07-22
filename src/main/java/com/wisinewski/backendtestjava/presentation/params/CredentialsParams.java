package com.wisinewski.backendtestjava.presentation.params;

import java.io.Serializable;

public class CredentialsParams implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cnpj;
	private String password;
	
	public CredentialsParams() {
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
