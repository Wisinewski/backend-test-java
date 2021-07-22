package com.wisinewski.backendtestjava.domain.usecases;

import java.util.List;

import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;

public interface LoadVehiclesByToken {

	List<Vehicle> load(String accessToken);
	
}
