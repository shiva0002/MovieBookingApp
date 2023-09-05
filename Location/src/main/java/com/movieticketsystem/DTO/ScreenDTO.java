package com.movieticketsystem.DTO;

import com.movieticketsystem.location.Entities.TimeSlots;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreenDTO {
    private String screenId;
    private String screenName;
    private String showDate;
    private TimeSlots timeSlot;
}
