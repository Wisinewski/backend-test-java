package com.wisinewski.backendtestjava.infra.repository.db.mysql;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wisinewski.backendtestjava.data.protocols.LoadEstablishmentByCNPJRepository;
import com.wisinewski.backendtestjava.data.protocols.establishment.AddEstablishmentRepository;
import com.wisinewski.backendtestjava.data.protocols.establishment.LoadEstablishmentByIdRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public interface EstablishmentMySQLRepository extends JpaRepository<Establishment, Long>, AddEstablishmentRepository, LoadEstablishmentByCNPJRepository, LoadEstablishmentByIdRepository {

	@Override
	public default void add(Establishment establishment) {
		save(establishment);
	}
	
	@Override
	@Query("SELECT e FROM Establishment e WHERE e.cnpj = :cnpj")
	public Establishment loadByCNPJ(@Param(value = "cnpj") String cnpj);
	
	@Override
	default Optional<Establishment> loadById(Long id) {
		return findById(id);
	}
	
}
