package com.wisinewski.backendtestjava.data.vehicle.loadAllVehicleTypes;

import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.wisinewski.backendtestjava.data.usecases.vehicle.DbLoadAllVehicleTypes;
import com.wisinewski.backendtestjava.domain.models.VehicleTest;
import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

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
	
	@Test
	public void should_return_null_if_LoadAllVehicleTypesRepository_returns_an_empty_list() {
		makeSut();
		loadAllVehicleTypesRepositorySpy.setResult(Collections.emptyList());
		List<VehicleType> vehicleTypes = dbLoadAllVehicleTypes.loadAll();
		Assert.assertNull(vehicleTypes);
	}
	
	@Test
	public void should_return_a_list_of_VehicleTypes_on_success() {
		makeSut();
		List<VehicleType> vehicleTypes = dbLoadAllVehicleTypes.loadAll();
		Assert.assertNotNull(vehicleTypes);
		Assert.assertTrue(vehicleTypes.get(0).equals(VehicleTest.mockVehicleType()));
	}
	
}
