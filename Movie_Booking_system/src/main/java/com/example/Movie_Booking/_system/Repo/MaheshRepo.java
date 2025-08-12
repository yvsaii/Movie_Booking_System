package com.example.Movie_Booking._system.Repo;
import com.example.Movie_Booking._system.Entity.Mahesh;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaheshRepo extends JpaRepository<Mahesh, Long> {
    List<Mahesh> findByStatus(String status);
    Mahesh findBySeatNumber(int seatNumber);

}
