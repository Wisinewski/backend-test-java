package com.wisinewski.backendtestjava.data.usecases.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wisinewski.backendtestjava.data.protocols.LoadEstablishmentByCNPJRepository;
import com.wisinewski.backendtestjava.domain.models.establishment.Establishment;
import com.wisinewski.backendtestjava.security.UserSS;

@Service
public class DbUserDetailsService implements UserDetailsService {
	
	private LoadEstablishmentByCNPJRepository loadEstablishmentByCNPJRepository;
	
	@Autowired
	public DbUserDetailsService(LoadEstablishmentByCNPJRepository loadEstablishmentByCNPJRepository) {
		this.loadEstablishmentByCNPJRepository = loadEstablishmentByCNPJRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String cnpj) throws UsernameNotFoundException {
		Establishment establishment = loadEstablishmentByCNPJRepository.loadByCNPJ(cnpj);
		if (establishment == null) {
			throw new UsernameNotFoundException(cnpj);
		}
		return new UserSS(establishment.getId().intValue(), establishment.getCnpj(), establishment.getPassword(), establishment.getProfiles());
	}

}
