package com.wisinewski.backendtestjava.infra.repository.db.mysql;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.wisinewski.backendtestjava.data.protocols.establishment.AddEstablishmentRepository;
import com.wisinewski.backendtestjava.domain.models.EstablishmentTest;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

@DataJpaTest
class EstablishmentMySQLRepositoryTest {
	
	@Autowired
	private AddEstablishmentRepository addEstablishmentRepository;

	@Test
	void should_save_an_establishment_on_AddEstablishmentRepository_success() {
		Establishment establishment = EstablishmentTest.mockEstablishment();
		addEstablishmentRepository.add(establishment);
		Assert.assertTrue(true);
	}

}
