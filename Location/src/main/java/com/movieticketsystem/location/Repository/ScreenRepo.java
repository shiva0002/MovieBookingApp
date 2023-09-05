package com.movieticketsystem.location.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieticketsystem.location.Entities.Screen;


public interface ScreenRepo extends JpaRepository<Screen,String> {

    Optional<Screen> findByScreenIdAndSeatsId(String screenId, String seatId);

    Optional<Screen> findByScreenName(String screenName);
    
}
