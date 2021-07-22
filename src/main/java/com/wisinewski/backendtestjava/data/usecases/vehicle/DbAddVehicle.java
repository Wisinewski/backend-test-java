package com.wisinewski.backendtestjava.data.usecases.vehicle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisinewski.backendtestjava.data.protocols.establishment.LoadEstablishmentByIdRepository;
import com.wisinewski.backendtestjava.data.protocols.vehicle.AddVehicleRepository;
import com.wisinewski.backendtestjava.data.protocols.vehicle.LoadVehicleTypeByIdRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;
import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;
import com.wisinewski.backendtestjava.domain.usecases.AddVehicle;
import com.wisinewski.backendtestjava.presentation.exceptions.ObjectNotFoundException;
import com.wisinewski.backendtestjava.presentation.params.VehicleParams;

@Service
public class DbAddVehicle implements AddVehicle {

	private LoadVehicleTypeByIdRepository loadVehicleTypeByIdRepository;
	private LoadEstablishmentByIdRepository loadEstablishmentByRepository;
	private AddVehicleRepository addVehicleRepository;
	
	@Autowired
	public DbAddVehicle(LoadVehicleTypeByIdRepository loadVehicleTypeByIdRepository, LoadEstablishmentByIdRepository loadEstablishmentByIdRepository, AddVehicleRepository addVehicleRepository) {
		this.loadVehicleTypeByIdRepository = loadVehicleTypeByIdRepository;
		this.loadEstablishmentByRepository = loadEstablishmentByIdRepository;
		this.addVehicleRepository = addVehicleRepository;
	}
	
	public void addVehicle(VehicleParams vehicleParams) {
		Optional<VehicleType> optionalVehicleType = loadVehicleTypeByIdRepository.loadById(vehicleParams.getVehicleType());
		if(optionalVehicleType.isEmpty()) {
			throw new ObjectNotFoundException();
		}
		Optional<Establishment> optionalEstablishment = loadEstablishmentByRepository.loadById(vehicleParams.getEstablishment());
		if(optionalEstablishment.isEmpty()) {
			throw new ObjectNotFoundException();
		}
		Vehicle vehicle = new Vehicle(vehicleParams.getBrand(), vehicleParams.getModel(), vehicleParams.getColor(), vehicleParams.getLicensePlate(), optionalVehicleType.get(), optionalEstablishment.get());
		addVehicleRepository.add(vehicle);
	}
	
}
