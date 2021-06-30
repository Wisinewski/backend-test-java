package com.wisinewski.backendtestjava.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.models.params.establishment.EstablishmentParams;
import com.wisinewski.backendtestjava.domain.usecases.AddEstablishment;
import com.wisinewski.backendtestjava.presentation.exceptions.CNPJInUseException;

@RestController
@RequestMapping(value = "/establishments")
public class EstablishmentController {
	
	private AddEstablishment addEstablishment;
	
	@Autowired
	public EstablishmentController(AddEstablishment addEstablishment) {
		this.addEstablishment = addEstablishment;
	}

	@PostMapping
	public ResponseEntity loadAll(@RequestBody EstablishmentParams establishmentParams) {
		try {
			Establishment establishment = Establishment.parseEstablishment(establishmentParams);
			addEstablishment.addEstablishment(establishment);
			return ResponseEntity.created(null).build();
		} catch (CNPJInUseException exception) {
			return ResponseEntity.status(409).body(exception.getMessage());
		} catch (Exception exception) {
			System.out.println(exception);
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
