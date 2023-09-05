package com.movieticketsystem.location.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieticketsystem.DTO.BookingDTO;
import com.movieticketsystem.location.Entities.Seat;
import com.movieticketsystem.location.Service.SeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;    

    @PostMapping("/addAll")
    @PreAuthorize("hasRole('Admin')")
    public String addSeats(@RequestBody List<Seat> Seat) {
        if(Seat != null && !Seat.isEmpty()) {
            seatService.insertAll(Seat);
            return String.format("Added %d Seat.", Seat.size());
        } else {
            return "REQUEST_NO_BODY";
        }
    }

    @PostMapping("/book")
    @PreAuthorize("hasAnyRole('Admin','Users')")
    public void bookTickets(@RequestBody BookingDTO bookingDTO){
        
    }
}
