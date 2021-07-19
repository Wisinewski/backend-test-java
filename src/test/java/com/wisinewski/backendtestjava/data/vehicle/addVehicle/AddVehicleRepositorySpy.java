package com.wisinewski.backendtestjava.data.vehicle.addVehicle;

import com.wisinewski.backendtestjava.data.protocols.vehicle.AddVehicleRepository;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;

public class AddVehicleRepositorySpy implements AddVehicleRepository {

	private Vehicle vehicle;
	
	public void add(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
}
