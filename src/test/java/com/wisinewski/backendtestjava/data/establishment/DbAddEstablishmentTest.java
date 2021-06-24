package com.wisinewski.backendtestjava.data.establishment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisinewski.backendtestjava.data.usecases.establishment.DbAddEstablishment;
import com.wisinewski.backendtestjava.domain.models.EstablishmentTest;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

@SpringBootTest
public class DbAddEstablishmentTest {
	
	private DbAddEstablishment dbAddEstablishment;
	private LoadEstablishmentByCNPJRepositorySpy loadEstablishmentByCNPJRepositorySpy;
	
	@Before
	public void init() {
		loadEstablishmentByCNPJRepositorySpy = new LoadEstablishmentByCNPJRepositorySpy();
		dbAddEstablishment = new DbAddEstablishment(loadEstablishmentByCNPJRepositorySpy);
	}

	@Test
	public void should_call_LoadEstablishmentByCNPJRepository_with_correct_value() {
		Establishment establishment = EstablishmentTest.mockEstablishment();
		dbAddEstablishment.addEstablishment(establishment);
		Assert.assertTrue(loadEstablishmentByCNPJRepositorySpy.getCnpj().equals(establishment.getCnpj()));
	}

}
