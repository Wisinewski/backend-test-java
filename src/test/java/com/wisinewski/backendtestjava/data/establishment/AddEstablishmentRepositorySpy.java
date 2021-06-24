package com.wisinewski.backendtestjava.data.establishment;

import com.wisinewski.backendtestjava.data.protocols.AddEstablishmentRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public class AddEstablishmentRepositorySpy implements AddEstablishmentRepository {
	
	private Establishment establishment; 

	@Override
	public void add(Establishment establishment) {
		this.establishment = establishment;
		return;
	}
	
	public Establishment getEstablishment() {
		return establishment;
	}

}
