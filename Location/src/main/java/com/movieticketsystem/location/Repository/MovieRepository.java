package com.movieticketsystem.location.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieticketsystem.location.Entities.Movies;

public interface MovieRepository extends JpaRepository<Movies, String> {

    Optional<Movies> findByMovieName(String movieName);

    Movies deleteByMovieName(String movieName);

}
