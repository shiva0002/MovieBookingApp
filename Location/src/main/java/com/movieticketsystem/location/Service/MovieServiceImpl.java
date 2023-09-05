package com.movieticketsystem.location.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketsystem.DTO.ScreenDTO;
import com.movieticketsystem.location.Entities.Movies;
import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Exception.MovieNotFoundException;
import com.movieticketsystem.location.Repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movies addMovie(Movies movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movies getMovie(String movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id " + movieId + " not found"));
    }

    @Override
    public Movies updateMovie(String movieId, Movies movie) {
        Movies pastMovie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id " + movieId + " not found"));
        pastMovie.setMovieName(movie.getMovieName());
        pastMovie.setRatings(movie.getRatings());
        pastMovie.setReleaseDate(movie.getReleaseDate());
        pastMovie.setAbout(movie.getAbout());

        return movieRepository.save(pastMovie);

    }

    @Override
    public void deleteMovie(String movieId) {
        Movies movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id " + movieId + " not found"));


        movieRepository.deleteById(movie.getMovieId());
    }

    @Override
    public List<Movies> getAllMoviesReleasedThisMonth(LocalDate today) {

//        return movieRepository.findAll().stream().filter(movie -> movie.getReleaseDate().isAfter(today.minusWeeks(3)))
//                .collect(Collectors.toList());
        return movieRepository.findAll().stream().filter(movie ->{
            String movieDate = movie.getReleaseDate();
            LocalDate releaseDate = LocalDate.parse(movieDate, DateTimeFormatter.ofPattern("yyyy-mm-dd"));
            return releaseDate.isAfter(today.minusWeeks(3));
        }).collect(Collectors.toList());
    }

    @Override
    public List<ScreenDTO> getAllScreens(String movieId) {
        Movies movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id " + movieId + " not found"));
        List<Screen> screens = movie.getScreens();
        List<ScreenDTO> screenDTOs = new ArrayList<>();

        for(Screen screen : screens){
            ScreenDTO screenDTO = new ScreenDTO(screen.getScreenId(),screen.getScreenName(),screen.getShowDate(),screen.getTimeSlot());
            screenDTOs.add(screenDTO);
        }
        return screenDTOs;
        
    }

}
