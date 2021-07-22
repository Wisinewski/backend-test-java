package com.wisinewski.backendtestjava.domain.usecases;

import java.util.List;

import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;

public interface LoadAllVehiclesByEstablishment {

	List<Vehicle> load(Long id);
	
}
