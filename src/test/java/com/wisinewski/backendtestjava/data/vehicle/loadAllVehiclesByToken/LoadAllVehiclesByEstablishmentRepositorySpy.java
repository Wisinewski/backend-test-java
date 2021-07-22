package com.wisinewski.backendtestjava.data.vehicle.loadAllVehiclesByToken;

import java.util.ArrayList;
import java.util.List;

import com.wisinewski.backendtestjava.data.protocols.vehicle.LoadAllVehiclesByEstablishmentRepository;
import com.wisinewski.backendtestjava.domain.models.VehicleTest;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;

public class LoadAllVehiclesByEstablishmentRepositorySpy implements LoadAllVehiclesByEstablishmentRepository {
	
	private Establishment establishment;
	private List<Vehicle> result;
	
	public LoadAllVehiclesByEstablishmentRepositorySpy() {
		result = new ArrayList<Vehicle>();
		result.add(VehicleTest.mockVehicle());
		result.add(VehicleTest.mockVehicle());
	}
	
	@Override
	public List<Vehicle> loadAllByEstablishment(Establishment establishment) {
		this.establishment = establishment;
		return result;
	}
	
	public Establishment getEstablishment() {
		return establishment;
	}
	
}
