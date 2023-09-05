package com.movieticketsystem.location.Service;

import java.util.List;
import java.util.Map;

import com.movieticketsystem.location.Entities.City;

public interface CityService {
    
    City addCity(City city);

    List<String> getAllCity();

    City updateCity(String cityName,City city);

    City getCityByName(String cityName);

    void deleteCityById(String cityId);

    Map<String,String> getAllTheatres(String cityName);
}
