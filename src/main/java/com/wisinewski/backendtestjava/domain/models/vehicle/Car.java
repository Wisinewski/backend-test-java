package com.wisinewski.backendtestjava.domain.models.vehicle;

public class Car extends Vehicle {
	
	private static final long serialVersionUID = 1L;

	public Car(String brand, String model, String color, String licensePlate, VehicleType vehicleType) {
		super(brand, model, color, licensePlate, vehicleType);
	}

}
