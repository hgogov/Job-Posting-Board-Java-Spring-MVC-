package com.company.jobs.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime time;
    private int code;
    private String error;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    public ErrorResponse(String message, HttpStatus httpStatus) {
        this(httpStatus);
        this.message = message;
    }

    public ErrorResponse(HttpStatus httpStatus) {
        this.time = LocalDateTime.now();
        this.code = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
