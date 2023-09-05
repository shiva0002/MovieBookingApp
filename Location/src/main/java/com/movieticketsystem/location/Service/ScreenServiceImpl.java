package com.movieticketsystem.location.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieticketsystem.location.Entities.Screen;
import com.movieticketsystem.location.Entities.Seat;
import com.movieticketsystem.location.Exception.ScreenNotFoundException;
import com.movieticketsystem.location.Exception.SeatNotAvailableException;
import com.movieticketsystem.location.Repository.ScreenRepo;

@Service
public class ScreenServiceImpl implements ScreenService {

    @Autowired
    private ScreenRepo screenRepo;

    @Autowired
    private SeatService seatService;

    @Override
    public Screen addScreen(Screen newScreen) {
        Screen screen = screenRepo.save(newScreen);
        return screen;
    }

    @Override
    public Screen updateScreen(String screenId, Screen screen) {
        Screen tempScreen = screenRepo.findById(screenId).orElseThrow(()->new ScreenNotFoundException("Screen: "+screenId+" not found"));
        tempScreen.setScreenName(screen.getScreenName());
        tempScreen.setSeats(screen.getSeats());

        Screen newScreen = screenRepo.save(tempScreen);
        return newScreen;
    }

    @Override
    public Screen getScreenById(String screenId) {
        Screen screen = screenRepo.findById(screenId).orElseThrow(()->new ScreenNotFoundException("Screen: "+screenId+" not found"));
        
        return screen;
    }

    @Override
    public void deleteScreenById(String screenId) {
        screenRepo.deleteById(screenId);
    }

    // public Seat selectSeat(String screenId, String seatId) {
    //     Optional<Screen> screenOptional = screenRepo.findByScreenIdAndSeatsId(screenId, seatId);
    //     Screen screen = screenOptional.orElseThrow(() -> new NotFoundException("Screen or seat not found with provided IDs"));

    //     List<Seat> seats = screen.getSeats();
    //     Seat selectedSeat = seats.stream()
    //             .filter(seat -> seat.getId().equals(seatId))
    //             .findFirst()
    //             .orElseThrow(() -> new NotFoundException("Seat not found with id: " + seatId));

    //     if (selectedSeat.isAvailable()) {
    //         selectedSeat.setAvailable(false);
    //         screenRepo.save(screen);
    //     } else {
    //         throw new SeatNotAvailableException("Seat not available");
    //     }

    //     return selectedSeat;
    // }

    @Override
    public List<Seat> getAllAvailableSeats(String screenId) {
       Screen screen = screenRepo.findById(screenId).orElseThrow(()-> new ScreenNotFoundException("Screen with Id: "+screenId+" not found"));
        List<Seat> allSeats = screen.getSeats();
        List<Seat> availableSeats = allSeats.stream().filter(e -> e.isAvailable()).collect(Collectors.toList());
        return availableSeats;
    }

    @Override
    public String selectSeat(String screenName, List<String> seats) {
        List<Seat> availableSeats = getAllAvailableSeats(screenName);

        for(String s:seats){
            for(Seat seat:availableSeats){
                if(seat.getSeatNumber().equals(s)){
                    return seatService.updateSeat(s);
                }
                else{
                    throw new SeatNotAvailableException("Seat with seat number "+s+" not available");
                }
            }
        }

        return "Not Able to Book Seats";
        
    }
    
}
