package com.wisinewski.backendtestjava.data.vehicle.loadAllVehicleTypes;

import org.junit.Assert;
import org.junit.Test;
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
	
	@Test
	public void should_call_LoadAllVehicleTypesRepository() {
		makeSut();
		dbLoadAllVehicleTypes.loadAll();
		Assert.assertTrue(loadAllVehicleTypesRepositorySpy.getWasCalled());
	}
	
}
