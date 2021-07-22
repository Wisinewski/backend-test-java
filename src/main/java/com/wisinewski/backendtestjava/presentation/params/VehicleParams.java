package com.wisinewski.backendtestjava.presentation.params;

public class VehicleParams {
	
	private String brand;
	private String model;
	private String color;
	private String licensePlate;
	private Long vehicleType;
	private Long establishment;
	
	public VehicleParams() {
	}
	
	public VehicleParams(String brand, String model, String color, String licensePlate, Long vehicleType, Long establishment) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.licensePlate = licensePlate;
		this.vehicleType = vehicleType;
		this.establishment = establishment;
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

	public Long getVehicleType() {
		return vehicleType;
	}
	
	public Long getEstablishment() {
		return establishment;
	}
	
}
