package com.wisinewski.backendtestjava.data.establishment.addEstablishment;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisinewski.backendtestjava.data.establishment.LoadEstablishmentByCNPJRepositorySpy;
import com.wisinewski.backendtestjava.data.usecases.establishment.DbAddEstablishment;
import com.wisinewski.backendtestjava.domain.models.EstablishmentTest;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.presentation.exceptions.CNPJInUseException;

@SpringBootTest
public class DbAddEstablishmentTest {
	
	private DbAddEstablishment dbAddEstablishment;
	private LoadEstablishmentByCNPJRepositorySpy loadEstablishmentByCNPJRepositorySpy;
	private AddEstablishmentRepositorySpy addEstablishmentRepositorySpy;
	
	public void makeSut() {
		loadEstablishmentByCNPJRepositorySpy = new LoadEstablishmentByCNPJRepositorySpy();
		addEstablishmentRepositorySpy = new AddEstablishmentRepositorySpy();
		dbAddEstablishment = new DbAddEstablishment(loadEstablishmentByCNPJRepositorySpy, addEstablishmentRepositorySpy);
	}
	
	public void makeSut(LoadEstablishmentByCNPJRepositorySpy injectedLoadEstablishmentByCNPJRepositorySpy) {
		loadEstablishmentByCNPJRepositorySpy = injectedLoadEstablishmentByCNPJRepositorySpy;
		dbAddEstablishment = new DbAddEstablishment(loadEstablishmentByCNPJRepositorySpy, addEstablishmentRepositorySpy);
	}
	
	public void makeSut(AddEstablishmentRepositorySpy injectedAddEstablishmentRepositorySpy) {
		addEstablishmentRepositorySpy = injectedAddEstablishmentRepositorySpy;
		dbAddEstablishment = new DbAddEstablishment(loadEstablishmentByCNPJRepositorySpy, addEstablishmentRepositorySpy);
	}

	@Test
	public void should_call_LoadEstablishmentByCNPJRepository_with_correct_value() {
		makeSut();
		Establishment establishment = EstablishmentTest.mockEstablishment();
		dbAddEstablishment.addEstablishment(establishment);
		Assert.assertTrue(loadEstablishmentByCNPJRepositorySpy.getCnpj().equals(establishment.getCnpj()));
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_if_LoadEstablishmentByCNPJRepository_throws() {
		loadEstablishmentByCNPJRepositorySpy = Mockito.mock(LoadEstablishmentByCNPJRepositorySpy.class);
		makeSut(loadEstablishmentByCNPJRepositorySpy);
		Establishment establishment = EstablishmentTest.mockEstablishment();
		when(loadEstablishmentByCNPJRepositorySpy.loadByCNPJ(establishment.getCnpj())).thenThrow(new RuntimeException());
		dbAddEstablishment.addEstablishment(establishment);
	}
	
	@Test(expected = CNPJInUseException.class)
	public void should_throw_CNPJInUseException_if_already_exists_an_establishment_with_received_cnpj() {
		makeSut();
		Establishment establishment = EstablishmentTest.mockEstablishment();
		loadEstablishmentByCNPJRepositorySpy.setResult(establishment);
		dbAddEstablishment.addEstablishment(establishment);
	}
	
	@Test
	public void should_call_AddEstablishmentRepository_with_correct_value() {
		makeSut();
		Establishment establishment = EstablishmentTest.mockEstablishment();
		dbAddEstablishment.addEstablishment(establishment);
		Assert.assertTrue(addEstablishmentRepositorySpy.getEstablishment().equals(establishment));
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_if_AddEstablishmentRepository_throws() {
		addEstablishmentRepositorySpy = Mockito.mock(AddEstablishmentRepositorySpy.class);
		makeSut(addEstablishmentRepositorySpy);
		Establishment establishment = EstablishmentTest.mockEstablishment();
		doThrow(new RuntimeException()).when(addEstablishmentRepositorySpy).add(establishment);
		dbAddEstablishment.addEstablishment(establishment);
	}

}
