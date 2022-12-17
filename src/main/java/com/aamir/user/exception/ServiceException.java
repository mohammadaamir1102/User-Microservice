package com.aamir.user.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends Exception {

    private ServiceError serviceError;
    private HttpStatus httpStatus;

    public ServiceException(ServiceError serviceError, HttpStatus httpStatus) {
        super(serviceError.msg);
        this.serviceError = serviceError;
        this.httpStatus = httpStatus;
    }
}
