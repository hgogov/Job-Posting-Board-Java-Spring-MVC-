package com.company.jobs.exception;

public class UserAlreadyExistsException extends RuntimeException{

    private static final long serialVersionUID = -4798483697621073595L;

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
