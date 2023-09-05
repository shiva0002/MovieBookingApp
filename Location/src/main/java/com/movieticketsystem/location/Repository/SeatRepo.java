package com.movieticketsystem.location.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieticketsystem.location.Entities.Seat;

public interface SeatRepo extends JpaRepository<Seat,String>{
    
    Optional<Seat> findBySeatNumber(String seatNumber);
    
}
