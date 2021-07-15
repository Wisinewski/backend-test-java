package com.wisinewski.backendtestjava.data.protocols.establishment;

import java.util.List;

import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public interface LoadAllEstablishmentsRepository {

	List<Establishment> loadAll();
	
}
