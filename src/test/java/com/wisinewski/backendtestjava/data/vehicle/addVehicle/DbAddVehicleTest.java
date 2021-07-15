package com.wisinewski.backendtestjava.data.vehicle.addVehicle;

import static org.mockito.Mockito.doThrow;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.wisinewski.backendtestjava.data.usecases.vehicle.DbAddVehicle;
import com.wisinewski.backendtestjava.domain.models.VehicleTest;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;


public class DbAddVehicleTest {

	private DbAddVehicle dbAddVehicle;
	private AddVehicleRepositorySpy addVehicleRepositorySpy;
	
	public void makeSut() {
		addVehicleRepositorySpy = new AddVehicleRepositorySpy();
		dbAddVehicle = new DbAddVehicle(addVehicleRepositorySpy);
	}
	
	public void makeSut(AddVehicleRepositorySpy addVehicleRepositorySpy) {
		this.addVehicleRepositorySpy = addVehicleRepositorySpy;
		dbAddVehicle = new DbAddVehicle(this.addVehicleRepositorySpy);
	}
	
	@Test
	public void should_call_AddVehicleRepository_with_correct_value() {
		makeSut();
		Vehicle vehicle = VehicleTest.mockVehicle();
		dbAddVehicle.addVehicle(vehicle);
		Assert.assertEquals(addVehicleRepositorySpy.getVehicle(), vehicle);
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_if_AddVehicleRepository_throws() {
		addVehicleRepositorySpy = Mockito.mock(AddVehicleRepositorySpy.class);
		makeSut(addVehicleRepositorySpy);
		Vehicle vehicle = VehicleTest.mockVehicle();
		doThrow(new RuntimeException()).when(addVehicleRepositorySpy).add(vehicle);
		dbAddVehicle.addVehicle(vehicle);
	}
	
}
