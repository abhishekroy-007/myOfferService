package com.offer.management.service.exception;

public class CohortNotFoundException extends RuntimeException{
    public CohortNotFoundException(String message) {
        super(message);
    }
}
