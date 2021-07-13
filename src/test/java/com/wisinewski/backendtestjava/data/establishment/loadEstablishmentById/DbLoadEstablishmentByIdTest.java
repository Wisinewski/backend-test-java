package com.wisinewski.backendtestjava.data.establishment.loadEstablishmentById;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisinewski.backendtestjava.data.usecases.establishment.DbLoadEstablishmentById;
import com.wisinewski.backendtestjava.domain.models.EstablishmentTest;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

@SpringBootTest
public class DbLoadEstablishmentByIdTest {
	
	private DbLoadEstablishmentById dbLoadEstablishmentById;
	private LoadEstablishmentByIdRepositorySpy loadEstablishmentByIdRepositorySpy;
	
	public void makeSut() {
		loadEstablishmentByIdRepositorySpy = new LoadEstablishmentByIdRepositorySpy();
		dbLoadEstablishmentById = new DbLoadEstablishmentById(loadEstablishmentByIdRepositorySpy);
	}
	
	public void makeSut(LoadEstablishmentByIdRepositorySpy injectedLoadEstablishmentByIdRepositorySpy) {
		loadEstablishmentByIdRepositorySpy = injectedLoadEstablishmentByIdRepositorySpy;
		dbLoadEstablishmentById = new DbLoadEstablishmentById(loadEstablishmentByIdRepositorySpy);
	}
	
	@Test
	public void should_call_LoadEstablishmentByIdRepository_with_correct_value() {
		makeSut();
		Long id = 1L;
		dbLoadEstablishmentById.loadById(id);
		Assert.assertTrue(loadEstablishmentByIdRepositorySpy.getId().equals(id));
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_if_LoadEstablishmentByIdRepository_throws() {
		loadEstablishmentByIdRepositorySpy = Mockito.mock(LoadEstablishmentByIdRepositorySpy.class);
		makeSut(loadEstablishmentByIdRepositorySpy);
		Long id = 1L;
		when(loadEstablishmentByIdRepositorySpy.loadById(id)).thenThrow(new RuntimeException());
		dbLoadEstablishmentById.loadById(id);
	}
	
	@Test
	public void should_return_an_establishment_on_success() {
		makeSut();
		Establishment establishment = dbLoadEstablishmentById.loadById(1L);
		Assert.assertTrue(establishment instanceof Establishment);
	}

}
