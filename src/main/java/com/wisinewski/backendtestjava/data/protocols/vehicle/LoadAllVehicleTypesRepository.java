package com.wisinewski.backendtestjava.data.protocols.vehicle;

import java.util.List;

import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

public interface LoadAllVehicleTypesRepository {

	List<VehicleType> loadAll();
	
}
