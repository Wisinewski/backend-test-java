package com.wisinewski.backendtestjava.domain.models.vehicle;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicles")
public abstract class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String model;
	private String color;
	private String licensePlate;
	
	@Column(name = "id_vehicle_type")
	private VehicleType vehicleType;
	
	protected Vehicle(String brand, String model, String color, String licensePlate, VehicleType vehicleType) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.licensePlate = licensePlate;
		this.vehicleType = vehicleType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
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
		Vehicle other = (Vehicle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
