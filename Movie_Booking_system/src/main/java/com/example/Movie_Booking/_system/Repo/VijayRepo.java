package com.example.Movie_Booking._system.Repo;

import com.example.Movie_Booking._system.Entity.Vijay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VijayRepo extends JpaRepository<Vijay, Long> {
    Vijay findBySeatNumber(int seatNumber);
}
