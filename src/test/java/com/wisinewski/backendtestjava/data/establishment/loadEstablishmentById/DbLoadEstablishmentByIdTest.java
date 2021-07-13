package com.wisinewski.backendtestjava.data.establishment.loadEstablishmentById;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisinewski.backendtestjava.data.usecases.establishment.DbLoadEstablishmentById;

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

}
