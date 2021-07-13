package com.wisinewski.backendtestjava.data.protocols.establishment;

import java.util.Optional;

import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public interface LoadEstablishmentByIdRepository {

	Optional<Establishment> loadById(Long id);
	
}
