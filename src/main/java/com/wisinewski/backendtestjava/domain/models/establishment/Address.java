package com.wisinewski.backendtestjava.domain.models.establishment;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wisinewski.backendtestjava.domain.models.params.establishment.AddressParams;

@Entity
@Table(name = "addresses")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String country;
	private String state;
	private String city;
	private String district;
	private String street;
	private String number;
	private String complement;
	
	public Address() {
	}

	public Address(Long id, String country, String state, String city, String district, String street, String number,
			String complement) {
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.district = district;
		this.street = street;
		this.number = number;
		this.complement = complement;
	}
	
	public static Address parseAddress(AddressParams addressParams) {
		return new Address(null, addressParams.getCountry(), addressParams.getState(), addressParams.getCity(), addressParams.getDistrict(), addressParams.getStreet(), addressParams.getNumber(), addressParams.getComplement());
	}
	
	public Long getId() {
		return id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
