package com.movieticketsystem.location.Exception;

public class SeatNotAvailableException extends RuntimeException {
    
    public SeatNotAvailableException(String message){
        super(message);
    }
}
