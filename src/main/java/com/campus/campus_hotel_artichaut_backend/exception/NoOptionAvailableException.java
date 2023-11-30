package com.campus.campus_hotel_artichaut_backend.exception;

public class NoOptionAvailableException extends Exception {
    public NoOptionAvailableException() {
        super(String.format("No options available"));
    }
}
