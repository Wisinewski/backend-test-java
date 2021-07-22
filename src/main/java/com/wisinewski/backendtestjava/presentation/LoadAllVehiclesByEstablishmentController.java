package com.wisinewski.backendtestjava.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisinewski.backendtestjava.data.usecases.security.DbUser;
import com.wisinewski.backendtestjava.data.usecases.vehicle.DbLoadAllVehiclesByEstablishment;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;
import com.wisinewski.backendtestjava.security.UserSS;

@RestController
@RequestMapping(value = "/vehicles")
public class LoadAllVehiclesByEstablishmentController {
	
	private DbLoadAllVehiclesByEstablishment dbLoadAllVehiclesByEstablishment;

	@Autowired
	public LoadAllVehiclesByEstablishmentController(DbLoadAllVehiclesByEstablishment dbLoadAllVehiclesByEstablishment) {
		this.dbLoadAllVehiclesByEstablishment = dbLoadAllVehiclesByEstablishment;
	}

	@GetMapping
	public ResponseEntity handle() {
		try {
			UserSS user = DbUser.authenticated();
			Long id = Long.valueOf(user.getId());
			List<Vehicle> vehicles = dbLoadAllVehiclesByEstablishment.load(id);
			return ResponseEntity.ok(vehicles);
		} catch(Exception exception) {
			System.out.println(exception);
			return ResponseEntity.internalServerError().build();
		}
	}

}
