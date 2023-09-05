package com.movieticketsystem.location.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketsystem.location.Entities.City;
import com.movieticketsystem.location.Entities.Movies;
import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Entities.Seat;
import com.movieticketsystem.location.Entities.Theatre;
import com.movieticketsystem.location.Exception.CityNotFoundException;
import com.movieticketsystem.location.Repository.CityRepo;
import com.movieticketsystem.location.Repository.MovieRepository;
import com.movieticketsystem.location.Repository.ScreenRepo;
import com.movieticketsystem.location.Repository.SeatRepo;
import com.movieticketsystem.location.Repository.TheatreRepo;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private TheatreRepo theatreRepo;

    @Autowired
    private ScreenRepo screenRepo;

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private MovieRepository movieRepo;

    @Override
    public City addCity(City newCity) {

        List<Theatre> theatres = newCity.getTheatre();

        for (Theatre theatre : theatres) {

            List<Movies> movies = theatre.getMovies();

            for (Movies movie : movies) {
                List<Screen> screens = movie.getScreens();
                for (Screen screen : screens) {

                    List<Seat> seats = screen.getSeats();
                    for (Seat seat : seats) {
                        seatRepo.save(seat);
                    }
                    screenRepo.save(screen);
                }
                movieRepo.save(movie);
            }
            theatreRepo.save(theatre);
        }

        City city = cityRepo.save(newCity);
        return city;
    }

    @Override
    public City updateCity(String cityName, City city) {

        City tempCity = cityRepo.findByCityName(cityName)
                .orElseThrow(() -> new CityNotFoundException("City: " + cityName + " not found"));
        tempCity.setCityName(city.getCityName());
        tempCity.setState(city.getState());

        City newCity = cityRepo.save(tempCity);
        return newCity;
    }

    @Override
    public City getCityByName(String cityName) {
        City city = cityRepo.findByCityName(cityName)
                .orElseThrow(() -> new CityNotFoundException("City with Name: " + cityName + " not found"));

        return city;
    }

    @Override
    public void deleteCityById(String cityId) {
        cityRepo.deleteById(cityId);
    }

    // @Override
    // public List<Theatre> getAllTheatres(String cityName) {
    // City city = cityRepo.findByCityName(cityName)
    // .orElseThrow(() -> new CityNotFoundException("City with Id: " + cityName + "
    // not found"));

    // return city.getTheatre();
    // }

    @Override
    public Map<String, String> getAllTheatres(String cityName) {
        City city = cityRepo.findByCityName(cityName)
                .orElseThrow(() -> new CityNotFoundException("City with Id: " + cityName + " not found"));

        Map<String, String> theatres = new HashMap<>();
        for (Theatre theatre : city.getTheatre()) {
            theatres.put(theatre.getTheatreName(), theatre.getTheatreAddress());
        }
        return theatres;
    }

    @Override
    public List<String> getAllCity() {
        List<City> cities = cityRepo.findAll();
        List<String> cityNames = new ArrayList<>();
        for (City city : cities) {
            cityNames.add(city.getCityName());
        }

        return cityNames;
    }

}
