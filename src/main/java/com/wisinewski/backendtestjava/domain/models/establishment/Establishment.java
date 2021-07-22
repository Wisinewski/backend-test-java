package com.wisinewski.backendtestjava.domain.models.establishment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wisinewski.backendtestjava.domain.enums.ProfileLevel;
import com.wisinewski.backendtestjava.domain.models.params.establishment.EstablishmentParams;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;

@Entity
@Table(name = "establishments")
public class Establishment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String cnpj;
	
	@JsonIgnore
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_establishment", referencedColumnName = "id")
	private Set<Phone> phones = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_establishment", referencedColumnName = "id")
	private Set<Space> spaces = new HashSet<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PROFILES")
	private Set<Integer> profiles = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "establishment")
	private List<Vehicle> vehicles = new ArrayList<>();
	
	public Establishment() {
	}

	public Establishment(Long id, String name, String cnpj, Set<Phone> phones, Set<Space> spaces, Address address, String password) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.phones = phones;
		this.spaces = spaces;
		this.address = address;
		this.password = password;
		addProfile(ProfileLevel.CLIENT);
	}
	
	public static Establishment parseEstablishment(EstablishmentParams establishmentParams) {
		Set<Phone> parsedPhones = establishmentParams.getPhones().stream().map(Phone::parsePhone).collect(Collectors.toSet());
		Set<Space> parsedSpaces = establishmentParams.getSpaces().stream().map(Space::parseSpace).collect(Collectors.toSet());
		Address parsedAddress = Address.parseAddress(establishmentParams.getAddress());
		return new Establishment(null, establishmentParams.getName(), establishmentParams.getCnpj(), parsedPhones, parsedSpaces, parsedAddress, establishmentParams.getPassword());
	}

	public Long getId() {
		return id;
	}

	public String getname() {
		return name;
	}

	public String getCnpj() {
		return cnpj;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Phone> getPhones() {
		return Collections.unmodifiableSet(phones);
	}

	public Set<Space> getSpaces() {
		return Collections.unmodifiableSet(spaces);
	}

	public Address getAddress() {
		return address;
	}
	
	public Set<ProfileLevel> getProfiles() {
		return profiles.stream().map(code -> ProfileLevel.toEnum(code)).collect(Collectors.toSet());
	}
	
	public void addProfile(ProfileLevel profile) {
		profiles.add(profile.getCode());
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
		Establishment other = (Establishment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
