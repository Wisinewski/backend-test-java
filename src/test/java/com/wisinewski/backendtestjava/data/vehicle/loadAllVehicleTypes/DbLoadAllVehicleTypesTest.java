package com.wisinewski.backendtestjava.data.vehicle.loadAllVehicleTypes;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisinewski.backendtestjava.data.usecases.vehicle.DbLoadAllVehicleTypes;

@SpringBootTest
public class DbLoadAllVehicleTypesTest {

	private DbLoadAllVehicleTypes dbLoadAllVehicleTypes;
	private LoadAllVehicleTypesRepositorySpy loadAllVehicleTypesRepositorySpy;
	
	public void makeSut() {
		loadAllVehicleTypesRepositorySpy = new LoadAllVehicleTypesRepositorySpy();
		dbLoadAllVehicleTypes = new DbLoadAllVehicleTypes(loadAllVehicleTypesRepositorySpy);
	}
	
	public void makeSut(LoadAllVehicleTypesRepositorySpy loadAllVehicleTypesRepositorySpy) {
		this.loadAllVehicleTypesRepositorySpy = loadAllVehicleTypesRepositorySpy;
		dbLoadAllVehicleTypes = new DbLoadAllVehicleTypes(this.loadAllVehicleTypesRepositorySpy);
	}
	
	@Test
	public void should_call_LoadAllVehicleTypesRepository() {
		makeSut();
		dbLoadAllVehicleTypes.loadAll();
		Assert.assertTrue(loadAllVehicleTypesRepositorySpy.getWasCalled());
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_if_LoadAllVehicleTypesRepository_throws() {
		loadAllVehicleTypesRepositorySpy = Mockito.mock(LoadAllVehicleTypesRepositorySpy.class);
		makeSut(loadAllVehicleTypesRepositorySpy);
		when(loadAllVehicleTypesRepositorySpy.loadAll()).thenThrow(new RuntimeException());
		dbLoadAllVehicleTypes.loadAll();
	}
	
}
