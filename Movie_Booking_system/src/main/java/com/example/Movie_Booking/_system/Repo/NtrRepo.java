package com.example.Movie_Booking._system.Repo;

import com.example.Movie_Booking._system.Entity.Ntr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NtrRepo extends JpaRepository<Ntr, Long> {
    Ntr findBySeatNumber(int seatNumber);
}
