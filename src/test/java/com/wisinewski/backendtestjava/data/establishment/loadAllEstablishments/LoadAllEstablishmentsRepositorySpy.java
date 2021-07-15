package com.wisinewski.backendtestjava.data.establishment.loadAllEstablishments;

import java.util.ArrayList;
import java.util.List;

import com.wisinewski.backendtestjava.data.protocols.establishment.LoadAllEstablishmentsRepository;
import com.wisinewski.backendtestjava.domain.models.EstablishmentTest;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public class LoadAllEstablishmentsRepositorySpy implements LoadAllEstablishmentsRepository {
	
	private List<Establishment> result;
	private Boolean wasCalled = false;
	
	public LoadAllEstablishmentsRepositorySpy() {
		result = new ArrayList<Establishment>();
		result.add(EstablishmentTest.mockEstablishment());
	}

	@Override
	public List<Establishment> loadAll() {
		wasCalled = true;
		return result;
	}
	
	public void setResult(List<Establishment> result) {
		this.result = result;
	}
	
	public Boolean getWasCalled() {
		return wasCalled;
	}

}
