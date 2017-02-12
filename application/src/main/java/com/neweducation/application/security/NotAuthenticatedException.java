package com.neweducation.application.security;

public class NotAuthenticatedException extends Exception{
    public NotAuthenticatedException() { super(); }
    public NotAuthenticatedException(String message) { super(message); }
    public NotAuthenticatedException(String message, Throwable cause) { super(message, cause); }
    public NotAuthenticatedException(Throwable cause) { super(cause); }
}
