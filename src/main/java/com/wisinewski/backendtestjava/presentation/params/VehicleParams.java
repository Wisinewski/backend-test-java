package com.wisinewski.backendtestjava.presentation.params;

public class VehicleParams {
	
	private String brand;
	private String model;
	private String color;
	private String licensePlate;
	private Long vehicleType;
	
	public VehicleParams() {
	}
	
	public VehicleParams(String brand, String model, String color, String licensePlate, Long vehicleType) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.licensePlate = licensePlate;
		this.vehicleType = vehicleType;
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
	
}
