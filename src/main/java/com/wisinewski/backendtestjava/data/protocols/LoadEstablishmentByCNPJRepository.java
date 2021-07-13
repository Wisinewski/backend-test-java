package com.wisinewski.backendtestjava.data.protocols;

import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public interface LoadEstablishmentByCNPJRepository {

	Establishment loadByCNPJ(String cnpj);
	
}
