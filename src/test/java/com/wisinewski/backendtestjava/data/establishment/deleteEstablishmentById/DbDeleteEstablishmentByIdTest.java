package com.wisinewski.backendtestjava.data.establishment.deleteEstablishmentById;

import org.junit.Assert;
import org.junit.Test;

import com.wisinewski.backendtestjava.data.usecases.establishment.DbDeleteEstablishmentById;

public class DbDeleteEstablishmentByIdTest {

	private DbDeleteEstablishmentById dbDeleteEstablishmentById;
	private DeleteEstablishmentByIdRepositorySpy deleteEstablishmentByIdRepositorySpy;
	
	private void makeSut() {
		deleteEstablishmentByIdRepositorySpy = new DeleteEstablishmentByIdRepositorySpy();
		dbDeleteEstablishmentById = new DbDeleteEstablishmentById(deleteEstablishmentByIdRepositorySpy);
	}
	
	@Test
	public void should_call_DeleteEstablishmentByIdRepositorySpy_with_correct_value() {
		makeSut();
		Long id = 1L;
		dbDeleteEstablishmentById.deleteById(id);
		Assert.assertTrue(deleteEstablishmentByIdRepositorySpy.getId().equals(id));
	}
	
}
