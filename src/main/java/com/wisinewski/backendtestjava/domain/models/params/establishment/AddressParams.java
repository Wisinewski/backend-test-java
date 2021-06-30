package com.wisinewski.backendtestjava.domain.models.params.establishment;

public class AddressParams {

	private String country;
	private String state;
	private String city;
	private String district;
	private String street;
	private String number;
	private String complement;

	public AddressParams(Long id, String country, String state, String city, String district, String street, String number,
			String complement) {
		this.country = country;
		this.state = state;
		this.city = city;
		this.district = district;
		this.street = street;
		this.number = number;
		this.complement = complement;
	}

	public String getCountry() {
		return country;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public String getStreet() {
		return street;
	}

	public String getNumber() {
		return number;
	}

	public String getComplement() {
		return complement;
	}
	
}
