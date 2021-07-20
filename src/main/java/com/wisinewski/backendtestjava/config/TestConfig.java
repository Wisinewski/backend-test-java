package com.wisinewski.backendtestjava.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wisinewski.backendtestjava.data.protocols.Hasher;
import com.wisinewski.backendtestjava.domain.enums.ProfileLevel;
import com.wisinewski.backendtestjava.domain.models.establishment.Address;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.models.establishment.Phone;
import com.wisinewski.backendtestjava.domain.models.establishment.Space;
import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;
import com.wisinewski.backendtestjava.infra.repository.db.mysql.EstablishmentMySQLRepository;
import com.wisinewski.backendtestjava.infra.repository.db.mysql.VehicleTypeMySQLRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private EstablishmentMySQLRepository establishmentMySQLRepository;
	
	@Autowired
	private VehicleTypeMySQLRepository vehicleTypeMySQLRepository;
	
	@Autowired
	private Hasher hasher;

	@Override
	public void run(String... args) throws Exception {
		VehicleType vehicleType = new VehicleType(null, "any_type");
		vehicleTypeMySQLRepository.add(vehicleType);
		
		Address address = new Address(null, "any_country", "any_state", "any_city", "any_district", "any_street", "000", "any_complement");
		Set<Phone> phones = new HashSet<>();
		phones.add(new Phone(null, "00", "000000000"));
		Set<Space> spaces = new HashSet<>();
		spaces.add(new Space(null, 1, 50));
		Establishment establishment = new Establishment(null, "any_name", "000", phones, spaces, address, hasher.hash("any_password"));
		establishmentMySQLRepository.add(establishment);
		
		address = new Address(null, "any_country", "any_state", "any_city", "any_district", "any_street", "000", "any_complement");
		phones = new HashSet<>();
		phones.add(new Phone(null, "00", "000000000"));
		spaces = new HashSet<>();
		spaces.add(new Space(null, 1, 50));
		Establishment establishmentAdmin = new Establishment(null, "any_name", "000", phones, spaces, address, hasher.hash("any_password"));
		establishmentAdmin.addProfile(ProfileLevel.ADMIN);
		establishmentMySQLRepository.add(establishmentAdmin);
	}
	
}
