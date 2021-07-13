package com.wisinewski.backendtestjava.data.establishment.loadEstablishmentById;

import com.wisinewski.backendtestjava.data.protocols.establishment.LoadEstablishmentByIdRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public class LoadEstablishmentByIdRepositorySpy implements LoadEstablishmentByIdRepository {
	
	private Long id; 
	private Establishment establishment;

	@Override
	public Establishment loadById(Long id) {
		this.id = id;
		return establishment;
	}
	
	public Long getId() {
		return id;
	}

}
