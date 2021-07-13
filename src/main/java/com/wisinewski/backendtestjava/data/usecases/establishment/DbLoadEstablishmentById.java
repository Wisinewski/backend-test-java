package com.wisinewski.backendtestjava.data.usecases.establishment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisinewski.backendtestjava.data.protocols.establishment.LoadEstablishmentByIdRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.usecases.LoadEstablishmentById;

@Service
public class DbLoadEstablishmentById implements LoadEstablishmentById {

	private LoadEstablishmentByIdRepository loadEstablishmentByIdRepository;
	
	@Autowired
	public DbLoadEstablishmentById(LoadEstablishmentByIdRepository loadEstablishmentByIdRepository) {
		this.loadEstablishmentByIdRepository = loadEstablishmentByIdRepository;
	}

	@Override
	public Establishment loadById(Long id) {
		Optional<Establishment> optionalEstablishment = loadEstablishmentByIdRepository.loadById(id);
		return optionalEstablishment.get();
	}
	
}
