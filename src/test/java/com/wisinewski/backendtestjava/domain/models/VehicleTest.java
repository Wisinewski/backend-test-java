package com.wisinewski.backendtestjava.domain.models;

import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

public class VehicleTest {

	public static VehicleType mockVehicleType() {
		return new VehicleType(null, "Car");
	}
	
}
