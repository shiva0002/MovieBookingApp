package com.movieticketsystem.location.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketsystem.DTO.MovieDTO;
import com.movieticketsystem.location.Entities.Movies;
import com.movieticketsystem.location.Entities.Theatre;
import com.movieticketsystem.location.Exception.TheatreNotFoundException;
import com.movieticketsystem.location.Repository.TheatreRepo;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreRepo theatreRepo;

    @Override
    public Theatre addTheatre(Theatre newTheatre) {
        Theatre theatre = theatreRepo.save(newTheatre);
        return theatre;
    }

    @Override
    public Theatre updateTheatre(String theatreName, Theatre theatre) {
        Theatre tempTheatre = theatreRepo.findByTheatreName(theatreName)
                .orElseThrow(() -> new TheatreNotFoundException("Theatre: " + theatreName + " not found"));
        tempTheatre.setTheatreName(theatre.getTheatreName());
        tempTheatre.setTheatreAddress(theatre.getTheatreAddress());

        Theatre newTheatre = theatreRepo.save(tempTheatre);
        return newTheatre;
    }

    @Override
    public Theatre getTheatreById(String theatreId) {
        Theatre theatre = theatreRepo.findById(theatreId)
                .orElseThrow(() -> new TheatreNotFoundException("Theatre with Id: " + theatreId + " not found"));

        return theatre;
    }

    @Override
    public void deleteTheatreById(String theatreId) {
        theatreRepo.deleteById(theatreId);
    }

    @Override
    public List<MovieDTO> getAllMovies(String theatreName) {
        Theatre theatre = theatreRepo.findByTheatreName(theatreName)
                .orElseThrow(() -> new TheatreNotFoundException("Theatre with Name: " + theatreName + " not found"));
        List<MovieDTO> movies = new ArrayList<>();
        
        for (Movies movie : theatre.getMovies()) {
            MovieDTO movieDTO = new MovieDTO(movie.getMovieId(),movie.getMovieName(),movie.getReleaseDate(),movie.getRatings(),movie.getAbout());
            movies.add(movieDTO);
        }

        return movies;
    }

}
