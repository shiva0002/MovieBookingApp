package com.movieticketsystem.booking.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;

    private String showDate;
    private String showTime;
    private String movieName;
    private String screenName;
    private String paymentStatus;
    private LocalDateTime bookingDateTime;
    private String userId;
    private String userName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

}
