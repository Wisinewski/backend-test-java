package com.wisinewski.backendtestjava.data.establishment.loadAllEstablishments;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisinewski.backendtestjava.data.usecases.establishment.DbLoadAllEstablishments;

@SpringBootTest
public class DbLoadAllEstablishmentsTest {
	
	private DbLoadAllEstablishments dbLoadAllEstablishments;
	private LoadAllEstablishmentsRepositorySpy loadAllEstablishmentsRepositorySpy;
	
	public void makeSut() {
		loadAllEstablishmentsRepositorySpy = new LoadAllEstablishmentsRepositorySpy();
		dbLoadAllEstablishments = new DbLoadAllEstablishments(loadAllEstablishmentsRepositorySpy);
	}
	
	@Test
	public void should_call_LoadAllEstablishmentsRepository() {
		makeSut();
		dbLoadAllEstablishments.loadAll();
		Assert.assertTrue(loadAllEstablishmentsRepositorySpy.getWasCalled());
	}

}
