package com.wisinewski.backendtestjava.data.protocols.vehicle;

import java.util.Optional;

import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

public interface LoadVehicleTypeByIdRepository {

	Optional<VehicleType> loadById(Long id);
	
}
