package com.wisinewski.backendtestjava.domain.models;

import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;
import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

public class VehicleTest {

	public static VehicleType mockVehicleType() {
		return new VehicleType(null, "Car");
	}
	
	public static Vehicle mockVehicle() {
		return new Vehicle("any_brand", "any_model", "any_color", "any_licensePlate", new VehicleType(null, "any_type"));
	}
	
}
