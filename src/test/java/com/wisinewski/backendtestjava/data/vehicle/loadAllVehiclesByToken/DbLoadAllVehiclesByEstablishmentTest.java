package com.wisinewski.backendtestjava.data.vehicle.loadAllVehiclesByToken;

import org.junit.Assert;
import org.junit.Test;

import com.wisinewski.backendtestjava.data.establishment.loadEstablishmentById.LoadEstablishmentByIdRepositorySpy;
import com.wisinewski.backendtestjava.data.usecases.vehicle.DbLoadAllVehiclesByEstablishment;

public class DbLoadAllVehiclesByEstablishmentTest {
	
	private LoadEstablishmentByIdRepositorySpy loadEstablishmentByIdRepositorySpy;
	private LoadAllVehiclesByEstablishmentRepositorySpy loadAllVehiclesByEstablishmentRepositorySpy;
	private DbLoadAllVehiclesByEstablishment dbLoadAllVehiclesByEstablishment;
	
	public void makeSut() {
		loadEstablishmentByIdRepositorySpy = new LoadEstablishmentByIdRepositorySpy();
		loadAllVehiclesByEstablishmentRepositorySpy = new LoadAllVehiclesByEstablishmentRepositorySpy();
		dbLoadAllVehiclesByEstablishment = new DbLoadAllVehiclesByEstablishment(loadEstablishmentByIdRepositorySpy, loadAllVehiclesByEstablishmentRepositorySpy);
	}
	
	@Test
	public void should_call_LoadAllVehiclesByEstablishmentRepository_with_correct_value() {
		makeSut();
		Long id = 1L;
		dbLoadAllVehiclesByEstablishment.load(id);
		Assert.assertEquals(loadEstablishmentByIdRepositorySpy.getId(), id);
	}

}
