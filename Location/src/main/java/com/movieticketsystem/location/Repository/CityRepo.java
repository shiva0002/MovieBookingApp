package com.movieticketsystem.location.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieticketsystem.location.Entities.City;

public interface CityRepo extends JpaRepository<City,String>{
    Optional<City> findByCityName(String cityName);
}
