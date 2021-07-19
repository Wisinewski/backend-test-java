package com.wisinewski.backendtestjava.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisinewski.backendtestjava.domain.usecases.AddVehicle;
import com.wisinewski.backendtestjava.presentation.exceptions.ObjectNotFoundException;
import com.wisinewski.backendtestjava.presentation.params.VehicleParams;

@RestController
@RequestMapping(value = "/vehicles")
public class AddVehicleController {
	
	private AddVehicle addVehicle;
	
	@Autowired
	public AddVehicleController(AddVehicle addVehicle) {
		this.addVehicle = addVehicle;
	}

	@PostMapping
	public ResponseEntity handle(@RequestBody VehicleParams vehicleParams) {
		try {
			addVehicle.addVehicle(vehicleParams);
			return ResponseEntity.noContent().build();
		} catch (ObjectNotFoundException exception) {
			return ResponseEntity.notFound().build();
		} catch (RuntimeException exception) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
