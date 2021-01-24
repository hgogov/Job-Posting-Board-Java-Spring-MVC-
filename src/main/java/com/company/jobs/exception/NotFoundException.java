package com.company.jobs.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1859616489004391607L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
