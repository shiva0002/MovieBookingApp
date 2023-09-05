package com.movieticketsystem.location.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketsystem.location.Entities.City;
import com.movieticketsystem.location.Entities.Theatre;
import com.movieticketsystem.location.Service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
    
    @Autowired
    private CityService cityService;
    
    @PostMapping
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City result = cityService.addCity(city);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @GetMapping
    @PreAuthorize("hasAnyRole('Admin','Users')")
    public ResponseEntity<List<String>> getAllCity(){
        return new ResponseEntity<>(cityService.getAllCity(),HttpStatus.OK);
    }

    @PutMapping("/{cityName}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<City> updateCity(@PathVariable String cityName, @RequestBody City city) {
        City result = cityService.updateCity(cityName, city);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{cityName}")
    @PreAuthorize("hasAnyRole('Admin','Users')")
    public ResponseEntity<City> getCityByName(@PathVariable String cityName) {
        City city = cityService.getCityByName(cityName);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @DeleteMapping("/{cityId}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Void> deleteCityById(@PathVariable String cityId) {
        cityService.deleteCityById(cityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{cityName}/getAllTheatres")
    @PreAuthorize("hasAnyRole('Admin','Users')")
    public ResponseEntity<Map<String,String>> getAllTheatres(@PathVariable String cityName) {
        return new ResponseEntity<>(cityService.getAllTheatres(cityName), HttpStatus.OK);
    }
}
