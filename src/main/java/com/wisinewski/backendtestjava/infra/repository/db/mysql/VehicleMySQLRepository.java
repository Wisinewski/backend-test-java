package com.wisinewski.backendtestjava.infra.repository.db.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisinewski.backendtestjava.data.protocols.vehicle.AddVehicleRepository;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;

public interface VehicleMySQLRepository extends JpaRepository<Vehicle, Long>, AddVehicleRepository {

	@Override
	public default void add(Vehicle vehicle) {
		save(vehicle);
	}
	
}
