package com.movieticketsystem.location.Service;

import java.time.LocalDate;
import java.util.List;

import com.movieticketsystem.DTO.ScreenDTO;
import com.movieticketsystem.location.Entities.Movies;
import com.movieticketsystem.location.Entities.Screen;

public interface MovieService {

    Movies addMovie(Movies movie);

    List<Movies> getAllMoviesReleasedThisMonth(LocalDate today);

    Movies getMovie(String movieId);

    Movies updateMovie(String movieId, Movies movie);

    void deleteMovie(String movieId);

    List<ScreenDTO> getAllScreens(String movieId);

}
