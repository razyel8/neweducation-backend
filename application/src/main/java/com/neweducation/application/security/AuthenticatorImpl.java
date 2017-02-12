package com.neweducation.application.security;

import dtos.UserTo;

public class AuthenticatorImpl implements Authenticator{


    public UserTo authenticateUser(String authToken) throws NotAuthenticatedException {

        //Strzał do bazy i pobranie użytkownika, który ma tak auth token. Jeśli nie ma to rzuć wyjątek NotAuthenticated
        boolean isUserInDB = false;
        if(isUserInDB){
            throw new NotAuthenticatedException();
        }

        return new UserTo();

    }
}
