package com.neweducation.application.security;

import org.springframework.stereotype.Component;

import dtos.UserTo;

@Component
public interface Authenticator {
	public UserTo authenticateUser(String authToken) throws NotAuthenticatedException;
}
