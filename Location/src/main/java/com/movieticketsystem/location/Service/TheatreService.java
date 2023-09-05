package com.movieticketsystem.location.Service;

import java.util.List;

import com.movieticketsystem.DTO.MovieDTO;
import com.movieticketsystem.location.Entities.Movies;
import com.movieticketsystem.location.Entities.Theatre;

public interface TheatreService {
    Theatre addTheatre(Theatre theatre);

    Theatre updateTheatre(String theatreName,Theatre theatre);

    Theatre getTheatreById(String theatreId);

    void deleteTheatreById(String theatreId);

    List<MovieDTO> getAllMovies(String theatreName);
}
