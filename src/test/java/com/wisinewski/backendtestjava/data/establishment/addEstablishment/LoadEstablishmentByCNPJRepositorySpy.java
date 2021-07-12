package com.wisinewski.backendtestjava.data.establishment;

import com.wisinewski.backendtestjava.data.protocols.LoadEstablishmentByCNPJRepository;
import com.wisinewski.backendtestjava.domain.models.EstablishmentTest;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public class LoadEstablishmentByCNPJRepositorySpy implements LoadEstablishmentByCNPJRepository {
	
	private String cnpj;
	private Establishment result;
	
	public LoadEstablishmentByCNPJRepositorySpy() {
		result = null;
	}

	public Establishment loadByCNPJ(String cnpj) {
		this.cnpj = cnpj;
		return result;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public Establishment getResult() {
		return result;
	}
	
	public void setResult(Establishment result) {
		this.result = result;
	}
	
}
