package com.wisinewski.backendtestjava.infra.repository.db.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wisinewski.backendtestjava.data.protocols.LoadEstablishmentByCNPJRepository;
import com.wisinewski.backendtestjava.data.protocols.establishment.AddEstablishmentRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;

public interface EstablishmentMySQLRepository extends JpaRepository<Establishment, Long>, AddEstablishmentRepository, LoadEstablishmentByCNPJRepository {

	@Override
	public default void add(Establishment establishment) {
		save(establishment);
	}
	
	@Override
	@Query("SELECT e FROM Establishment e WHERE e.cnpj = :cnpj")
	public Establishment loadByCNPJ(@Param(value = "cnpj") String cnpj);
	
}
