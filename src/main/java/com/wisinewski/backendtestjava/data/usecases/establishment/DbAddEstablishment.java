package com.wisinewski.backendtestjava.data.usecases.establishment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisinewski.backendtestjava.data.protocols.establishment.AddEstablishmentRepository;
import com.wisinewski.backendtestjava.data.protocols.establishment.LoadEstablishmentByCNPJRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.usecases.AddEstablishment;
import com.wisinewski.backendtestjava.presentation.exceptions.CNPJInUseException;

@Service
public class DbAddEstablishment implements AddEstablishment {
	
	private LoadEstablishmentByCNPJRepository loadEstablishmentByCNPJRepository;
	private AddEstablishmentRepository addEstablishmentRepository;
	
	@Autowired
	public DbAddEstablishment(LoadEstablishmentByCNPJRepository loadEstablishmentByCNPJRepository, AddEstablishmentRepository addEstablishmentRepository) {
		this.loadEstablishmentByCNPJRepository = loadEstablishmentByCNPJRepository;
		this.addEstablishmentRepository = addEstablishmentRepository;
	}

	@Override
	public void addEstablishment(Establishment establishment) {
		Optional<Establishment> existentEstablishment = Optional.ofNullable(loadEstablishmentByCNPJRepository.loadByCNPJ(establishment.getCnpj()));
		if (existentEstablishment.isPresent()) {
			throw new CNPJInUseException();
		}
		addEstablishmentRepository.add(establishment);
	}

}
