package com.wisinewski.backendtestjava.presentation;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.usecases.LoadEstablishmentById;

@RestController
@RequestMapping(value = "/establishments")
public class LoadEstablishmentByIdController {
	
	private LoadEstablishmentById loadEstablishmentById;
	
	@Autowired
	public LoadEstablishmentByIdController(LoadEstablishmentById loadEstablishmentById) {
		this.loadEstablishmentById = loadEstablishmentById;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity loadAll(@PathVariable Long id) {
		try {
			Establishment establishment = loadEstablishmentById.loadById(id);
			return ResponseEntity.ok(establishment);
		} catch (NoSuchElementException exception) {
			return ResponseEntity.notFound().build();
		} catch (Exception exception) {
			System.out.println(exception);
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
