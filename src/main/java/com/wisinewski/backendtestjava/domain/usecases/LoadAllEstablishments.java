package com.wisinewski.backendtestjava.domain.usecases;

import java.util.List;

import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public interface LoadAllEstablishments {

	List<Establishment> loadAll();
	
}
