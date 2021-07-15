package com.wisinewski.backendtestjava.data.vehicle.loadAllVehicleTypes;

import java.util.ArrayList;
import java.util.List;

import com.wisinewski.backendtestjava.data.protocols.vehicle.LoadAllVehicleTypesRepository;
import com.wisinewski.backendtestjava.domain.models.VehicleTest;
import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

public class LoadAllVehicleTypesRepositorySpy implements LoadAllVehicleTypesRepository {

	private List<VehicleType> result;
	private Boolean wasCalled = false;
	
	public LoadAllVehicleTypesRepositorySpy() {
		result = new ArrayList<VehicleType>();
		result.add(VehicleTest.mockVehicleType());
	}
	
	public List<VehicleType> loadAll() {
		wasCalled = true;
		return result;
	}
	
	public Boolean getWasCalled() {
		return wasCalled;
	}
	
}
