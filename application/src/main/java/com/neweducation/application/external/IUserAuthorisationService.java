package com.neweducation.application.external;

/**
 * Created by Maciej Wolański
 * maciekwski@gmail.com
 * on 05.02.2017.
 */
public interface IUserAuthorisationService {
    UserData authorizeUser(String login, String passwordHash); //probably
}

class UserData{
    int temp;
}
