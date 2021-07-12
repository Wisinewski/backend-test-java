package com.wisinewski.backendtestjava.data.establishment.addEstablishment;

import com.wisinewski.backendtestjava.data.protocols.establishment.AddEstablishmentRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public class AddEstablishmentRepositorySpy implements AddEstablishmentRepository {
	
	private Establishment establishment; 

	@Override
	public void add(Establishment establishment) {
		this.establishment = establishment;
	}
	
	public Establishment getEstablishment() {
		return establishment;
	}

}
