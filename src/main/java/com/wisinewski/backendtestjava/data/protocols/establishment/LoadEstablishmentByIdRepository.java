package com.wisinewski.backendtestjava.data.protocols.establishment;

import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public interface LoadEstablishmentByIdRepository {

	Establishment loadById(Long id);
	
}
