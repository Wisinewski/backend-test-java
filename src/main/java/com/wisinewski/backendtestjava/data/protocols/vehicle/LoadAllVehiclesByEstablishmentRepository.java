package com.wisinewski.backendtestjava.data.protocols.vehicle;

import java.util.List;

import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;

public interface LoadAllVehiclesByEstablishmentRepository {

	List<Vehicle> loadAllByEstablishment(Establishment establishment);
	
}
