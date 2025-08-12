package com.example.Movie_Booking._system.Repo;

import com.example.Movie_Booking._system.Entity.Ramoji;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RamojiRepo extends JpaRepository<Ramoji, Long> {

    List<Ramoji> findByStatus(String status);

    Ramoji findBySeatNumber(int seatNumber);
}
