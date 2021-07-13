package com.wisinewski.backendtestjava.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisinewski.backendtestjava.domain.usecases.DeleteEstablishmentById;

@RestController
@RequestMapping(value = "/establishments")
public class DeleteEstablishmentByIdController {
	
	private DeleteEstablishmentById deleteEstablishmentById;
	
	@Autowired
	public DeleteEstablishmentByIdController(DeleteEstablishmentById deleteEstablishmentById) {
		this.deleteEstablishmentById = deleteEstablishmentById;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity handle(@PathVariable Long id) {
		try {
			deleteEstablishmentById.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception exception) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
