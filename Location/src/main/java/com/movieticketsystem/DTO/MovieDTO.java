package com.movieticketsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private String movieId;
    private String movieName;
    private String releaseDate;
    private Double ratings;
    private String about;
}
