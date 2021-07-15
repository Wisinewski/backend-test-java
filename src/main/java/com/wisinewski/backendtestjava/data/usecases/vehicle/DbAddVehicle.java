package com.wisinewski.backendtestjava.data.usecases.vehicle;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisinewski.backendtestjava.data.protocols.vehicle.AddVehicleRepository;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;
import com.wisinewski.backendtestjava.domain.usecases.AddVehicle;

public class DbAddVehicle implements AddVehicle {

	private AddVehicleRepository addVehicleRepository;
	
	@Autowired
	public DbAddVehicle(AddVehicleRepository addVehicleRepository) {
		this.addVehicleRepository = addVehicleRepository;
	}
	
	public void addVehicle(Vehicle vehicle) {
		addVehicleRepository.add(vehicle);
	}
	
}
