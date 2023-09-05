package com.movieticketsystem.location.Controller;

import java.time.LocalDate;
import java.util.List;

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

import com.movieticketsystem.DTO.ScreenDTO;
import com.movieticketsystem.location.Entities.Movies;
import com.movieticketsystem.location.Service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Movies> addMovie(@RequestBody Movies movie) {
        return new ResponseEntity<Movies>(movieService.addMovie(movie), HttpStatus.CREATED);
    }

    @GetMapping("/{movieId}")
    @PreAuthorize("hasAnyRole('Admin','Users')")
    public ResponseEntity<Movies> getMovie(@PathVariable String movieId) {
        return new ResponseEntity<Movies>(movieService.getMovie(movieId), HttpStatus.OK);
    }

    @PutMapping("/{movieId}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Movies> updateMovie(@PathVariable String movieId, @RequestBody Movies movie) {
        return new ResponseEntity<Movies>(movieService.updateMovie(movieId, movie), HttpStatus.OK);
    }

    @DeleteMapping("/{movieId}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<String> deleteMovie(@PathVariable String movieId) {
        movieService.deleteMovie(movieId);

        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<List<Movies>> getAllMoviesReleasedThisMonth() {
        return new ResponseEntity<List<Movies>>(movieService.getAllMoviesReleasedThisMonth(LocalDate.now()),
                HttpStatus.OK);
    }

    @GetMapping("/{movieId}/getAllScreens")
    @PreAuthorize("hasAnyRole('Admin','Users')")
    public ResponseEntity<List<ScreenDTO>> getAllScreens(@PathVariable String movieId) {
        List<ScreenDTO> screens = movieService.getAllScreens(movieId);
        return new ResponseEntity<>(screens, HttpStatus.OK);
    }

}
