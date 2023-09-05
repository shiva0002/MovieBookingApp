package com.movieticketsystem.location.Service;

import java.util.List;

import com.movieticketsystem.location.Entities.Seat;

public interface SeatService {

    String updateSeat(String seatNumber);

    List<Seat> insertAll(List<Seat> s);
    
}
