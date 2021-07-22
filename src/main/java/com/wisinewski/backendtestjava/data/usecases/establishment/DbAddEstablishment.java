package com.wisinewski.backendtestjava.data.usecases.establishment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisinewski.backendtestjava.data.protocols.Hasher;
import com.wisinewski.backendtestjava.data.protocols.LoadEstablishmentByCNPJRepository;
import com.wisinewski.backendtestjava.data.protocols.establishment.AddEstablishmentRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.usecases.AddEstablishment;
import com.wisinewski.backendtestjava.presentation.exceptions.CNPJInUseException;

@Service
public class DbAddEstablishment implements AddEstablishment {
	
	private LoadEstablishmentByCNPJRepository loadEstablishmentByCNPJRepository;
	private AddEstablishmentRepository addEstablishmentRepository;
	private Hasher hasher;
	
	@Autowired
	public DbAddEstablishment(LoadEstablishmentByCNPJRepository loadEstablishmentByCNPJRepository, AddEstablishmentRepository addEstablishmentRepository, Hasher hasher) {
		this.loadEstablishmentByCNPJRepository = loadEstablishmentByCNPJRepository;
		this.addEstablishmentRepository = addEstablishmentRepository;
		this.hasher = hasher;
	}

	@Override
	public void addEstablishment(Establishment establishment) {
		Optional<Establishment> existentEstablishment = Optional.ofNullable(loadEstablishmentByCNPJRepository.loadByCNPJ(establishment.getCnpj()));
		if (existentEstablishment.isPresent()) {
			throw new CNPJInUseException();
		}
		establishment.setPassword(hasher.hash(establishment.getPassword()));
		addEstablishmentRepository.add(establishment);
	}

}
