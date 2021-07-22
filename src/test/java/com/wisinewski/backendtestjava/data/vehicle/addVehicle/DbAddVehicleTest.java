package com.wisinewski.backendtestjava.data.vehicle.addVehicle;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.wisinewski.backendtestjava.data.establishment.loadEstablishmentById.LoadEstablishmentByIdRepositorySpy;
import com.wisinewski.backendtestjava.data.usecases.vehicle.DbAddVehicle;
import com.wisinewski.backendtestjava.domain.models.VehicleTest;
import com.wisinewski.backendtestjava.domain.models.vehicle.Vehicle;
import com.wisinewski.backendtestjava.presentation.exceptions.ObjectNotFoundException;
import com.wisinewski.backendtestjava.presentation.params.VehicleParams;
import com.wisinewski.backendtestjava.presentation.params.VehicleParamsTest;


public class DbAddVehicleTest {

	private DbAddVehicle dbAddVehicle;
	private LoadVehicleTypeByIdRepositorySpy loadVehicleTypeByIdRepositorySpy;
	private LoadEstablishmentByIdRepositorySpy loadEstablishmentByIdRepositorySpy;
	private AddVehicleRepositorySpy addVehicleRepositorySpy;
	
	public void makeSut() {
		loadVehicleTypeByIdRepositorySpy = new LoadVehicleTypeByIdRepositorySpy();
		loadEstablishmentByIdRepositorySpy = new LoadEstablishmentByIdRepositorySpy();
		addVehicleRepositorySpy = new AddVehicleRepositorySpy();
		dbAddVehicle = new DbAddVehicle(loadVehicleTypeByIdRepositorySpy, loadEstablishmentByIdRepositorySpy, addVehicleRepositorySpy);
	}
	
	public void makeSut(AddVehicleRepositorySpy addVehicleRepositorySpy) {
		loadVehicleTypeByIdRepositorySpy = new LoadVehicleTypeByIdRepositorySpy();
		loadEstablishmentByIdRepositorySpy = new LoadEstablishmentByIdRepositorySpy();
		this.addVehicleRepositorySpy = addVehicleRepositorySpy;
		dbAddVehicle = new DbAddVehicle(loadVehicleTypeByIdRepositorySpy, loadEstablishmentByIdRepositorySpy, this.addVehicleRepositorySpy);
	}
	
	public void makeSut(LoadVehicleTypeByIdRepositorySpy loadVehicleTypeByIdRepositorySpy) {
		this.loadVehicleTypeByIdRepositorySpy = loadVehicleTypeByIdRepositorySpy;
		loadEstablishmentByIdRepositorySpy = new LoadEstablishmentByIdRepositorySpy();
		addVehicleRepositorySpy = new AddVehicleRepositorySpy();
		dbAddVehicle = new DbAddVehicle(this.loadVehicleTypeByIdRepositorySpy, loadEstablishmentByIdRepositorySpy, addVehicleRepositorySpy);
	}
	
	@Test
	public void should_call_LoadVehicleTypeByIdRepository_with_correct_value() {
		makeSut();
		VehicleParams vehicleParams = VehicleParamsTest.mockVehicleParams();
		dbAddVehicle.addVehicle(vehicleParams);
		Assert.assertEquals(vehicleParams.getVehicleType(), loadVehicleTypeByIdRepositorySpy.getId());
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_if_LoadVehicleTypeByIdRepository_throws() {
		loadVehicleTypeByIdRepositorySpy = Mockito.mock(LoadVehicleTypeByIdRepositorySpy.class);
		makeSut(loadVehicleTypeByIdRepositorySpy);
		VehicleParams vehicleParams = VehicleParamsTest.mockVehicleParams();
		when(loadVehicleTypeByIdRepositorySpy.loadById(vehicleParams.getVehicleType())).thenThrow(new RuntimeException());
		dbAddVehicle.addVehicle(vehicleParams);
	}
	
	@Test(expected = ObjectNotFoundException.class)
	public void should_throw_ObjectNotFoundException_if_LoadVehicleTypeByIdRepository_returns_an_empty_Optional() {
		makeSut();
		loadVehicleTypeByIdRepositorySpy.setResult(Optional.empty());
		VehicleParams vehicleParams = VehicleParamsTest.mockVehicleParams();
		dbAddVehicle.addVehicle(vehicleParams);
	}
	
	@Test
	public void should_call_AddVehicleRepository_with_correct_value() {
		makeSut();
		VehicleParams vehicleParams = VehicleParamsTest.mockVehicleParams();
		Vehicle vehicle = VehicleTest.mockVehicle();
		dbAddVehicle.addVehicle(vehicleParams);
		Assert.assertEquals(addVehicleRepositorySpy.getVehicle(), vehicle);
	}
	
	@Test(expected = RuntimeException.class)
	public void should_throw_if_AddVehicleRepository_throws() {
		addVehicleRepositorySpy = Mockito.mock(AddVehicleRepositorySpy.class);
		makeSut(addVehicleRepositorySpy);
		VehicleParams vehicleParams = VehicleParamsTest.mockVehicleParams();
		Vehicle vehicle = VehicleTest.mockVehicle();
		doThrow(new RuntimeException()).when(addVehicleRepositorySpy).add(vehicle);
		dbAddVehicle.addVehicle(vehicleParams);
	}
	
}
