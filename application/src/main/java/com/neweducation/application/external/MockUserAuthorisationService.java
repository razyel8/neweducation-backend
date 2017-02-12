package com.neweducation.application.external;

/**
 * Created by Maciej Wolański
 * maciekwski@gmail.com
 * on 05.02.2017.
 */
public class MockUserAuthorisationService implements IUserAuthorisationService {
    @Override
    public UserData authorizeUser(String login, String passwordHash) {
        return new UserData();
    }
}
