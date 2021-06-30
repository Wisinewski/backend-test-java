package com.wisinewski.backendtestjava.domain.models.params.establishment;

import java.util.HashSet;
import java.util.Set;

public class EstablishmentParams {

	private String name;
	private String cnpj;
	private Set<PhoneParams> phones = new HashSet<>();
	private AddressParams address;
	private Set<SpaceParams> spaces = new HashSet<>();

	public EstablishmentParams(Long id, String name, String cnpj, Set<PhoneParams> phones, Set<SpaceParams> spaces, AddressParams address) {
		this.name = name;
		this.cnpj = cnpj;
		this.phones = phones;
		this.spaces = spaces;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Set<PhoneParams> getPhones() {
		return phones;
	}

	public AddressParams getAddress() {
		return address;
	}

	public Set<SpaceParams> getSpaces() {
		return spaces;
	}
	
}
