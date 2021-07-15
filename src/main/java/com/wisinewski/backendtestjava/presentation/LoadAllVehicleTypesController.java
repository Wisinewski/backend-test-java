package com.wisinewski.backendtestjava.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisinewski.backendtestjava.domain.models.vehicle.VehicleType;
import com.wisinewski.backendtestjava.domain.usecases.LoadAllVehicleTypes;

@RestController
@RequestMapping(value = "/vehicle-types")
public class LoadAllVehicleTypesController {

	private LoadAllVehicleTypes loadAllVehicleTypes;

	@Autowired
	public LoadAllVehicleTypesController(LoadAllVehicleTypes loadAllVehicleTypes) {
		this.loadAllVehicleTypes = loadAllVehicleTypes;
	}

	@GetMapping
	public ResponseEntity handle() {
		try {
			List<VehicleType> vehicleTypes = loadAllVehicleTypes.loadAll();
			if (vehicleTypes == null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(vehicleTypes);
		} catch (RuntimeException exception) {
			return ResponseEntity.internalServerError().build();
		}
	}

}
