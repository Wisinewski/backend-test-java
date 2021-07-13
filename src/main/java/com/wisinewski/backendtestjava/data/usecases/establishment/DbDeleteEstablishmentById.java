package com.wisinewski.backendtestjava.data.usecases.establishment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisinewski.backendtestjava.data.protocols.establishment.DeleteEstablishmentByIdRepository;
import com.wisinewski.backendtestjava.domain.usecases.DeleteEstablishmentById;

@Service
public class DbDeleteEstablishmentById implements DeleteEstablishmentById {

	private DeleteEstablishmentByIdRepository deleteEstablishmentByIdRepository;
	
	@Autowired
	public DbDeleteEstablishmentById(DeleteEstablishmentByIdRepository deleteEstablishmentByIdRepository) {
		this.deleteEstablishmentByIdRepository = deleteEstablishmentByIdRepository;
	}

	@Override
	public void deleteById(Long id) {
		deleteEstablishmentByIdRepository.deleteById(id);
	}
	
}
