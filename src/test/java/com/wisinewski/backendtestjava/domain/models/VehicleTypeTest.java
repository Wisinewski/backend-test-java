package com.wisinewski.backendtestjava.domain.models;

import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;

public class VehicleTypeTest {

	public static VehicleType mockVehicleType() {
		return new VehicleType(1L, "any_type");
	}
	
}
