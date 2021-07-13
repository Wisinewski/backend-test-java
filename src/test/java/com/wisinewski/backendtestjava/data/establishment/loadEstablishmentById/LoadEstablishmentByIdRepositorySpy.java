package com.wisinewski.backendtestjava.data.establishment.loadEstablishmentById;

import java.util.Optional;

import com.wisinewski.backendtestjava.data.protocols.establishment.LoadEstablishmentByIdRepository;
import com.wisinewski.backendtestjava.domain.models.EstablishmentTest;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public class LoadEstablishmentByIdRepositorySpy implements LoadEstablishmentByIdRepository {
	
	private Long id; 
	private Optional<Establishment> result = Optional.of(EstablishmentTest.mockEstablishment());

	@Override
	public Optional<Establishment> loadById(Long id) {
		this.id = id;
		return result;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setResult(Optional<Establishment> result) {
		this.result = result;
	}

}
