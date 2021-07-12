package com.wisinewski.backendtestjava.data.establishment.deleteEstablishmentById;

import com.wisinewski.backendtestjava.data.protocols.establishment.DeleteEstablishmentByIdRepository;

public class DeleteEstablishmentByIdRepositorySpy implements DeleteEstablishmentByIdRepository {
	
	private Long id;

	@Override
	public void deleteById(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

}
