package com.wisinewski.backendtestjava.data.usecases.establishment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisinewski.backendtestjava.data.protocols.establishment.LoadAllEstablishmentsRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.usecases.LoadAllEstablishments;

@Service
public class DbLoadAllEstablishments implements LoadAllEstablishments {

	private LoadAllEstablishmentsRepository loadAllEstablishmentsRepository;
	
	@Autowired
	public DbLoadAllEstablishments(LoadAllEstablishmentsRepository loadAllEstablishmentsRepository) {
		this.loadAllEstablishmentsRepository = loadAllEstablishmentsRepository;
	}

	@Override
	public List<Establishment> loadAll() {
		List<Establishment> establishments = loadAllEstablishmentsRepository.loadAll();
		return establishments.isEmpty() ? null : establishments;
	}
	
}
