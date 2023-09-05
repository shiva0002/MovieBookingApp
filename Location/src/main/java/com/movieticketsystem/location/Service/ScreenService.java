package com.movieticketsystem.location.Service;

import java.util.List;

import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Entities.Seat;

public interface ScreenService {
    Screen addScreen(Screen screen);

    Screen updateScreen(String screenId,Screen screen);

    Screen getScreenById(String screenId);

    void deleteScreenById(String screenId);

    List<Seat> getAllAvailableSeats(String screenId);

    String selectSeat(String screenName, List<String> seats);
}
