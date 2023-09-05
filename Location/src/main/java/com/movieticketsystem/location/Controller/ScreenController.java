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

import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Entities.Seat;
import com.movieticketsystem.location.Service.ScreenService;


@RestController
@RequestMapping("/screen")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    @PostMapping
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Screen> addScreen(@RequestBody Screen screen) {
        Screen result = screenService.addScreen(screen);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("{screenId}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Screen> updateScreen(@PathVariable String screenId, @RequestBody Screen screen) {
        Screen result = screenService.updateScreen(screenId, screen);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("{screenId}")
    @PreAuthorize("hasAnyRole('Admin','Users')")
    public ResponseEntity<Screen> getScreenById(@PathVariable String screenId) {
        Screen screen = screenService.getScreenById(screenId);
        return new ResponseEntity<>(screen, HttpStatus.OK);
    }

    @DeleteMapping("{screenId}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Void> deleteScreenById(@PathVariable String screenId) {
        screenService.deleteScreenById(screenId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // @PostMapping("/{screenId}/seats/{seatId}/select")
    // public ResponseEntity<Seat> selectSeat(@PathVariable String screenId, @PathVariable String seatId) {
    //     Seat selectedSeat = screenService.selectSeat(screenId, seatId);
    //     return new ResponseEntity<>(selectedSeat, HttpStatus.OK);
    // }

    @GetMapping("/{screenId}/showSeats")
    @PreAuthorize("hasAnyRole('Admin','Users')")
    public ResponseEntity<List<Seat>> getAllAvailableSeats(@PathVariable String screenId){
        List<Seat> availableSeats = screenService.getAllAvailableSeats(screenId);
        return new ResponseEntity<>(availableSeats,HttpStatus.OK);      
    }

    
}
