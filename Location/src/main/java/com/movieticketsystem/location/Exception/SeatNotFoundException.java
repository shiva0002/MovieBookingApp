package com.movieticketsystem.location.Exception;

public class SeatNotFoundException extends RuntimeException {
    public SeatNotFoundException(String message){
        super(message);
    }
}
