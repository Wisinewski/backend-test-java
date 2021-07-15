package com.wisinewski.backendtestjava.data.usecases.establishment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisinewski.backendtestjava.data.protocols.establishment.LoadAllEstablishmentsRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.usecases.LoadAllEstablishments;

public class DbLoadAllEstablishments implements LoadAllEstablishments {

	private LoadAllEstablishmentsRepository loadAllEstablishmentsRepository;
	
	@Autowired
	public DbLoadAllEstablishments(LoadAllEstablishmentsRepository loadAllEstablishmentsRepository) {
		this.loadAllEstablishmentsRepository = loadAllEstablishmentsRepository;
	}

	@Override
	public List<Establishment> loadAll() {
		return loadAllEstablishmentsRepository.loadAll();
	}
	
}
