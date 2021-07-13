package com.wisinewski.backendtestjava.data.usecases.establishment;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisinewski.backendtestjava.data.protocols.establishment.LoadEstablishmentByIdRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.usecases.LoadEstablishmentById;

public class DbLoadEstablishmentById implements LoadEstablishmentById {

	private LoadEstablishmentByIdRepository loadEstablishmentByIdRepository;
	
	@Autowired
	public DbLoadEstablishmentById(LoadEstablishmentByIdRepository loadEstablishmentByIdRepository) {
		this.loadEstablishmentByIdRepository = loadEstablishmentByIdRepository;
	}

	@Override
	public Establishment loadById(Long id) {
		return loadEstablishmentByIdRepository.loadById(id);
	}
	
}
