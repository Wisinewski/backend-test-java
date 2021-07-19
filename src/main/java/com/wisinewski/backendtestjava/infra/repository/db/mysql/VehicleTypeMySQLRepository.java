package com.wisinewski.backendtestjava.infra.repository.db.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wisinewski.backendtestjava.data.protocols.vehicle.AddVehicleTypeRepository;
import com.wisinewski.backendtestjava.data.protocols.vehicle.LoadAllVehicleTypesRepository;
import com.wisinewski.backendtestjava.data.protocols.vehicle.LoadVehicleTypeByIdRepository;
import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

public interface VehicleTypeMySQLRepository extends JpaRepository<VehicleType, Long>, AddVehicleTypeRepository, LoadAllVehicleTypesRepository, LoadVehicleTypeByIdRepository {

	public default void add(VehicleType vehicleType) {
		save(vehicleType);
	}
	
	@Override
	public default List<VehicleType> loadAll() {
		return findAll();
	}
	
	@Override
	public default Optional<VehicleType> loadById(Long id) {
		return findById(id);
	}
	
}
