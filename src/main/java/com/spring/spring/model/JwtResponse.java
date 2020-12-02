package com.spring.spring.model;

public class JwtResponse {

	private final String jwttoken;
	private final Users userResponse;

	public JwtResponse(String jwttoken, Users user) {
		this.jwttoken = jwttoken;
		this.userResponse = user;

	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getNome() {
		return this.userResponse.getName();
	}

	public Long getId() {
		return this.userResponse.getId();
	}

	public String getEmail() {
		return this.userResponse.getEmail();
	}



}
