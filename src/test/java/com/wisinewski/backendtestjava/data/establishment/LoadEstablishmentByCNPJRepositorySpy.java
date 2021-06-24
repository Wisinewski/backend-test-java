package com.wisinewski.backendtestjava.data.establishment;

import java.util.Optional;

import com.wisinewski.backendtestjava.data.protocols.LoadEstablishmentByCNPJRepository;
import com.wisinewski.backendtestjava.domain.models.EstablishmentTest;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public class LoadEstablishmentByCNPJRepositorySpy implements LoadEstablishmentByCNPJRepository {
	
	private String cnpj;
	private Optional<Establishment> result;
	
	public LoadEstablishmentByCNPJRepositorySpy() {
		result = null;
	}

	public Establishment loadByCNPJ(String cnpj) {
		this.cnpj = cnpj;
		return EstablishmentTest.mockEstablishment();
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public Optional<Establishment> getResult() {
		return result;
	}
	
	public void setResult(Optional<Establishment> result) {
		this.result = result;
	}
	
}
