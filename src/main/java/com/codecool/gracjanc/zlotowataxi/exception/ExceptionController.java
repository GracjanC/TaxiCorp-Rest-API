package com.codecool.gracjanc.zlotowataxi.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    private Logger logger = LogManager.getLogger();

    @ExceptionHandler(DriverNotFoundException.class)
    public ResponseEntity<Object> driverExceptionHandler(DriverNotFoundException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        logger.error(bodyOfResponse);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(TaxiCabNotFoundException.class)
    public ResponseEntity<Object> taxiExceptionHandler(TaxiCabNotFoundException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        logger.error(bodyOfResponse);
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
