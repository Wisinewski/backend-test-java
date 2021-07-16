package com.wisinewski.backendtestjava.data.vehicle.addVehicle;

import java.util.Optional;

import com.wisinewski.backendtestjava.data.protocols.vehicle.LoadVehicleTypeByIdRepository;
import com.wisinewski.backendtestjava.domain.models.VehicleTypeTest;
import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

public class LoadVehicleTypeByIdRepositorySpy implements LoadVehicleTypeByIdRepository {

	private Long id;
	private Optional<VehicleType> result = Optional.of(VehicleTypeTest.mockVehicleType());
	
	@Override
	public Optional<VehicleType> loadById(Long id) {
		this.id = id;
		return result;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setResult(Optional<VehicleType> vehicleType) {
		this.result = vehicleType;
	}

}
