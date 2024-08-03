package com.api.tfmkt.exception;

public class ClubNotFoundException extends RuntimeException{
    public ClubNotFoundException(String message) {
        super(message);
    }
}
