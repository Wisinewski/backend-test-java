package com.wisinewski.backendtestjava.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.domain.usecases.LoadAllEstablishments;

@RestController
@RequestMapping(value = "/establishments")
public class LoadAllEstablishmentsController {
	
	private LoadAllEstablishments loadAllEstablishments;
	
	@Autowired
	public LoadAllEstablishmentsController(LoadAllEstablishments loadAllEstablishments) {
		this.loadAllEstablishments = loadAllEstablishments;
	}

	@GetMapping
	public ResponseEntity handle() {
		try {
			List<Establishment> establishments = loadAllEstablishments.loadAll();
			if (establishments == null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(establishments);
		} catch (Exception exception) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
}
