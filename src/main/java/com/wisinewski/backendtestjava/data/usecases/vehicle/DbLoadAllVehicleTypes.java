package com.wisinewski.backendtestjava.data.usecases.vehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisinewski.backendtestjava.data.protocols.vehicle.LoadAllVehicleTypesRepository;
import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;
import com.wisinewski.backendtestjava.domain.usecases.LoadAllVehicleTypes;

@Service
public class DbLoadAllVehicleTypes implements LoadAllVehicleTypes {
	
	private LoadAllVehicleTypesRepository loadAllVehicleTypesRepository;
	
	@Autowired
	public DbLoadAllVehicleTypes(LoadAllVehicleTypesRepository loadAllVehicleTypesRepository) {
		this.loadAllVehicleTypesRepository = loadAllVehicleTypesRepository;
	}

	public List<VehicleType> loadAll() {
		List<VehicleType> vehicleTypes = loadAllVehicleTypesRepository.loadAll();
		return vehicleTypes.isEmpty() ? null : vehicleTypes;
	}
	
}
