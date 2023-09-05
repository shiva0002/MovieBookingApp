package com.movieticketsystem.location.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketsystem.location.Entities.Seat;
import com.movieticketsystem.location.Exception.SeatNotFoundException;
import com.movieticketsystem.location.Repository.SeatRepo;

@Service
public class SeatServiceImpl implements SeatService{

    @Autowired
    private SeatRepo seatRepo;

    @Override
    public String updateSeat(String seatNumber) {
        Seat seat = seatRepo.findBySeatNumber(seatNumber).orElseThrow(() -> new SeatNotFoundException("Seat with seat number "+seatNumber+" not found"));       
        seat.setAvailable(!seat.isAvailable());
        seatRepo.save(seat);
        return "Seats selected";
    }

    @Override
    public List<Seat> insertAll(List<Seat> s) {
        return (List<Seat>)seatRepo.saveAll(s);
    }
}
