package com.wisinewski.backendtestjava.infra.repository.db.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wisinewski.backendtestjava.data.protocols.vehicle.AddVehicleRepository;
import com.wisinewski.backendtestjava.data.protocols.vehicle.LoadAllVehiclesByEstablishmentRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;

public interface VehicleMySQLRepository extends JpaRepository<Vehicle, Long>, AddVehicleRepository, LoadAllVehiclesByEstablishmentRepository {

	@Override
	public default void add(Vehicle vehicle) {
		save(vehicle);
	}
	
	@Override
	@Query("SELECT v FROM Vehicle v WHERE v.establishment = :establishment")
	public List<Vehicle> loadAllByEstablishment(@Param(value = "establishment") Establishment establishment);
	
}
