package com.movieticketsystem.location.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieticketsystem.location.Entities.Theatre;

public interface TheatreRepo extends JpaRepository<Theatre,String>{
    Optional<Theatre> findByTheatreName(String theatreName);
}
