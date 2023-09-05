package com.movieticketsystem.DTO;

import java.util.List;

import com.movieticketsystem.location.Entities.Seat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private String userId;
    private String userName;
    private String movieName;
    private String theatreAddress;
    private String screenName;
    private String bookingStatus;
    private String showDate;
    private String showTime;

    private List<Seat> seats;
}
