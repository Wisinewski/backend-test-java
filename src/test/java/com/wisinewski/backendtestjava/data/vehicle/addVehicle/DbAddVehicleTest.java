package com.wisinewski.backendtestjava.data.vehicle.addVehicle;

import org.junit.Assert;
import org.junit.Test;

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
	
	@Test
	public void should_call_AddVehicleRepository_with_correct_value() {
		makeSut();
		Vehicle vehicle = VehicleTest.mockVehicle();
		dbAddVehicle.addVehicle(vehicle);
		Assert.assertEquals(addVehicleRepositorySpy.getVehicle(), vehicle);
	}
	
}
