package com.wisinewski.backendtestjava.data.establishment.deleteEstablishmentById;

import static org.mockito.Mockito.doThrow;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.wisinewski.backendtestjava.data.usecases.establishment.DbDeleteEstablishmentById;

public class DbDeleteEstablishmentByIdTest {

	private DbDeleteEstablishmentById dbDeleteEstablishmentById;
	private DeleteEstablishmentByIdRepositorySpy deleteEstablishmentByIdRepositorySpy;
	
	private void makeSut() {
		deleteEstablishmentByIdRepositorySpy = new DeleteEstablishmentByIdRepositorySpy();
		dbDeleteEstablishmentById = new DbDeleteEstablishmentById(deleteEstablishmentByIdRepositorySpy);
	}
	
	private void makeSut(DeleteEstablishmentByIdRepositorySpy injectedDeleteEstablishmentByIdRepositorySpy) {
		deleteEstablishmentByIdRepositorySpy = injectedDeleteEstablishmentByIdRepositorySpy;
		dbDeleteEstablishmentById = new DbDeleteEstablishmentById(deleteEstablishmentByIdRepositorySpy);
	}
	
	@Test
	public void should_call_DeleteEstablishmentByIdRepository_with_correct_value() {
		makeSut();
		Long id = 1L;
		dbDeleteEstablishmentById.deleteById(id);
		Assert.assertTrue(deleteEstablishmentByIdRepositorySpy.getId().equals(id));
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_if_DeleteEstablishmentByIdRepository_throws() {
		deleteEstablishmentByIdRepositorySpy = Mockito.mock(DeleteEstablishmentByIdRepositorySpy.class);
		makeSut(deleteEstablishmentByIdRepositorySpy);
		Long id = 1L;
		doThrow(new RuntimeException()).when(deleteEstablishmentByIdRepositorySpy).deleteById(id);
		dbDeleteEstablishmentById.deleteById(id);
	}
	
}
