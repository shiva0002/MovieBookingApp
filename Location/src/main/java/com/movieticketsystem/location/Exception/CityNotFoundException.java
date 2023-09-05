package com.movieticketsystem.location.Exception;

public class CityNotFoundException extends RuntimeException{
    
    public CityNotFoundException(String message){
        super(message);
    }
}
