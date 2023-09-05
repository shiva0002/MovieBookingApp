package com.movieticketsystem.location.Controller;

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

import com.movieticketsystem.DTO.MovieDTO;
import com.movieticketsystem.location.Entities.Theatre;
import com.movieticketsystem.location.Service.TheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    
    @Autowired
    private TheatreService theatreService;

    @PostMapping
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre) {
        Theatre result = theatreService.addTheatre(theatre);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{theatreName}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable String theatreName, @RequestBody Theatre theatre) {
        Theatre result = theatreService.updateTheatre(theatreName, theatre);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{theatreId}")
    @PreAuthorize("hasAnyRole('Admin','Users')")
    public ResponseEntity<Theatre> getTheatreById(@PathVariable String theatreId) {
        Theatre theatre = theatreService.getTheatreById(theatreId);
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

    @DeleteMapping("/{theatreId}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Void> deleteTheatreById(@PathVariable String theatreId) {
        theatreService.deleteTheatreById(theatreId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{theatreName}/getMovies")
    @PreAuthorize("hasAnyRole('Admin','Users')")
    public ResponseEntity<List<MovieDTO>> getAllMovies(@PathVariable String theatreName){
        List<MovieDTO> movies = theatreService.getAllMovies(theatreName);

        return new ResponseEntity<List<MovieDTO>>(movies, HttpStatus.OK);
    }


    // @GetMapping("/{theatreName}/getAllscreens")
    // public ResponseEntity<List<String>> getAllScreens(@PathVariable String theatreName) {
    //     List<String> screens = theatreService.getAllScreens(theatreName);
    //     return new ResponseEntity<>(screens, HttpStatus.OK);
    // }
}
