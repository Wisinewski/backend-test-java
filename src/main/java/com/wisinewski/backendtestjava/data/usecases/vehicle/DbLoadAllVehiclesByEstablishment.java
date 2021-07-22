package com.wisinewski.backendtestjava.data.usecases.vehicle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisinewski.backendtestjava.data.protocols.establishment.LoadEstablishmentByIdRepository;
import com.wisinewski.backendtestjava.data.protocols.vehicle.LoadAllVehiclesByEstablishmentRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;
import com.wisinewski.backendtestjava.domain.usecases.LoadAllVehiclesByEstablishment;
import com.wisinewski.backendtestjava.presentation.exceptions.ObjectNotFoundException;

@Service
public class DbLoadAllVehiclesByEstablishment implements LoadAllVehiclesByEstablishment {
	
	private LoadEstablishmentByIdRepository loadEstablishmentByIdRepository;
	private LoadAllVehiclesByEstablishmentRepository loadVehiclesByEstablishmentRepository;
	
	@Autowired
	public DbLoadAllVehiclesByEstablishment(LoadEstablishmentByIdRepository loadEstablishmentByIdRepository, LoadAllVehiclesByEstablishmentRepository loadVehiclesByEstablishmentRepository) {
		this.loadEstablishmentByIdRepository = loadEstablishmentByIdRepository;
		this.loadVehiclesByEstablishmentRepository = loadVehiclesByEstablishmentRepository;
	}

	@Override
	public List<Vehicle> load(Long id) {
		Optional<Establishment> optionalEstablishment = loadEstablishmentByIdRepository.loadById(id);
		if (optionalEstablishment.isEmpty()) {
			throw new ObjectNotFoundException();
		}
		List<Vehicle> vehicles = loadVehiclesByEstablishmentRepository.loadAllByEstablishment(optionalEstablishment.get());
		return vehicles;
	}

}
