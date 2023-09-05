package com.movieticketsystem.location.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String movieId;
    private String movieName;
    private String releaseDate;
    private Double ratings;
    private String about;

    @OneToMany
    List<Screen> screens;
}
