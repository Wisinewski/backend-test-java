package com.wisinewski.backendtestjava.domain.usecases;

import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public interface LoadEstablishmentById {

	Establishment loadById(Long id);
	
}
