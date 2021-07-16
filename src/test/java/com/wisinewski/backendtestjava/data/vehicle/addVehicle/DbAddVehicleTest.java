package com.wisinewski.backendtestjava.data.vehicle.addVehicle;

import static org.mockito.Mockito.doThrow;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.wisinewski.backendtestjava.data.usecases.vehicle.DbAddVehicle;
import com.wisinewski.backendtestjava.domain.models.VehicleTest;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;
import com.wisinewski.backendtestjava.presentation.params.VehicleParams;
import com.wisinewski.backendtestjava.presentation.params.VehicleParamsTest;


public class DbAddVehicleTest {

	private DbAddVehicle dbAddVehicle;
	private LoadVehicleTypeByIdRepositorySpy loadVehicleTypeByIdRepositorySpy;
	private AddVehicleRepositorySpy addVehicleRepositorySpy;
	
	public void makeSut() {
		loadVehicleTypeByIdRepositorySpy = new LoadVehicleTypeByIdRepositorySpy();
		addVehicleRepositorySpy = new AddVehicleRepositorySpy();
		dbAddVehicle = new DbAddVehicle(loadVehicleTypeByIdRepositorySpy, addVehicleRepositorySpy);
	}
	
	public void makeSut(AddVehicleRepositorySpy addVehicleRepositorySpy) {
		loadVehicleTypeByIdRepositorySpy = new LoadVehicleTypeByIdRepositorySpy();
		this.addVehicleRepositorySpy = addVehicleRepositorySpy;
		dbAddVehicle = new DbAddVehicle(loadVehicleTypeByIdRepositorySpy, this.addVehicleRepositorySpy);
	}
	
	public void makeSut(LoadVehicleTypeByIdRepositorySpy loadVehicleTypeByIdRepositorySpy) {
		this.loadVehicleTypeByIdRepositorySpy = loadVehicleTypeByIdRepositorySpy;
		addVehicleRepositorySpy = new AddVehicleRepositorySpy();
		dbAddVehicle = new DbAddVehicle(this.loadVehicleTypeByIdRepositorySpy, addVehicleRepositorySpy);
	}
	
	@Test
	public void should_call_AddVehicleRepository_with_correct_value() {
		makeSut();
		VehicleParams vehicleParams = VehicleParamsTest.mockVehicleParams();
		Vehicle vehicle = VehicleTest.mockVehicle();
		dbAddVehicle.addVehicle(vehicleParams);
		Assert.assertEquals(addVehicleRepositorySpy.getVehicle(), vehicle);
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_if_AddVehicleRepository_throws() {
		addVehicleRepositorySpy = Mockito.mock(AddVehicleRepositorySpy.class);
		makeSut(addVehicleRepositorySpy);
		VehicleParams vehicleParams = VehicleParamsTest.mockVehicleParams();
		Vehicle vehicle = VehicleTest.mockVehicle();
		doThrow(new RuntimeException()).when(addVehicleRepositorySpy).add(vehicle);
		dbAddVehicle.addVehicle(vehicleParams);
	}
	
}
