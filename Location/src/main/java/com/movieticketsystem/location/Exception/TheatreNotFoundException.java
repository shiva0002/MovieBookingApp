package com.movieticketsystem.location.Exception;

public class TheatreNotFoundException extends RuntimeException{
    
    public TheatreNotFoundException(String message){
        super(message);
    }
}
