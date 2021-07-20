package com.wisinewski.backendtestjava.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisinewski.backendtestjava.config.JWTAuthenticationFailureHandler;
import com.wisinewski.backendtestjava.presentation.params.CredentialsParams;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private JWTUtil jwtUtil;

	@Autowired
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
		try {
			CredentialsParams credentialsParams = new ObjectMapper()
					.readValue(req.getInputStream(), CredentialsParams.class);
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(credentialsParams.getCnpj(), credentialsParams.getPassword(), new ArrayList<>());
			Authentication auth = authenticationManager.authenticate(authToken);
			return auth;
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String username = ((UserSS) auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		res.addHeader("Authorization", "Bearer: " + token);
	}

}
