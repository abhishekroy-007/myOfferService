package com.offer.management.service.exception;

public class BrandNotFoundException extends RuntimeException{
    public BrandNotFoundException(String message){
        super(message);
    }
}
