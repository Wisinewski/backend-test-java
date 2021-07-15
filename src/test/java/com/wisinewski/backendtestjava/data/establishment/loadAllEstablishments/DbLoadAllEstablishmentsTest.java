package com.wisinewski.backendtestjava.data.establishment.loadAllEstablishments;

import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisinewski.backendtestjava.data.usecases.establishment.DbLoadAllEstablishments;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

@SpringBootTest
public class DbLoadAllEstablishmentsTest {
	
	private DbLoadAllEstablishments dbLoadAllEstablishments;
	private LoadAllEstablishmentsRepositorySpy loadAllEstablishmentsRepositorySpy;
	
	public void makeSut() {
		loadAllEstablishmentsRepositorySpy = new LoadAllEstablishmentsRepositorySpy();
		dbLoadAllEstablishments = new DbLoadAllEstablishments(loadAllEstablishmentsRepositorySpy);
	}
	
	public void makeSut(LoadAllEstablishmentsRepositorySpy injectedLoadAllEstablishmentsRepositorySpy) {
		loadAllEstablishmentsRepositorySpy = injectedLoadAllEstablishmentsRepositorySpy;
		dbLoadAllEstablishments = new DbLoadAllEstablishments(loadAllEstablishmentsRepositorySpy);
	}
	
	@Test
	public void should_call_LoadAllEstablishmentsRepository() {
		makeSut();
		dbLoadAllEstablishments.loadAll();
		Assert.assertTrue(loadAllEstablishmentsRepositorySpy.getWasCalled());
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_if_LoadAllEstablishmentsRepository_throws() {
		loadAllEstablishmentsRepositorySpy = Mockito.mock(LoadAllEstablishmentsRepositorySpy.class);
		makeSut(loadAllEstablishmentsRepositorySpy);
		when(loadAllEstablishmentsRepositorySpy.loadAll()).thenThrow(new RuntimeException());
		dbLoadAllEstablishments.loadAll();
	}
	
	@Test
	public void should_return_null_if_LoadAllEstablishmentsRepository_returns_an_empty_list() {
		makeSut();
		loadAllEstablishmentsRepositorySpy.setResult(Collections.emptyList());
		List<Establishment> establishments = dbLoadAllEstablishments.loadAll();
		Assert.assertNull(establishments);
	}

}
