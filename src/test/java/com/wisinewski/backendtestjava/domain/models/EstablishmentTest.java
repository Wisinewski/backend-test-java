package com.wisinewski.backendtestjava.domain.models;

import java.util.HashSet;
import java.util.Set;

import com.wisinewski.backendtestjava.domain.models.establishment.Address;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.models.establishment.Phone;
import com.wisinewski.backendtestjava.domain.models.establishment.Space;

public class EstablishmentTest {

	public static Establishment mockEstablishment() {
		Address address = new Address(null, "any_country", "any_state", "any_city", "any_district", "any_street", "000", "any_complement");
		Set<Phone> phones = new HashSet<>();
		phones.add(new Phone(null, "00", "000000000"));
		Set<Space> spaces = new HashSet<>();
		spaces.add(new Space(null, 1, 50));
		
		return new Establishment(null, "any_name", "000", phones, spaces, address, "hashed_password");
	}
	
}
