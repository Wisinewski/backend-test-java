package com.wisinewski.backendtestjava.domain.usecases;

import java.util.List;

import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

public interface LoadAllVehicleTypes {

	List<VehicleType> loadAll();
	
}
