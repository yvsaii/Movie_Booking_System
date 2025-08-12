package com.example.Movie_Booking._system.Controller;

import com.example.Movie_Booking._system.Entity.Mahesh;
import com.example.Movie_Booking._system.Repo.MaheshRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MultipleTheater/mahesh/seats")
@CrossOrigin(origins = "*")
public class MaheshControl {

    @Autowired
    private MaheshRepo maheshRepo;

    // Get all seats and their status
    @GetMapping
    public List<Mahesh> getAllSeats() {
        return maheshRepo.findAll();
    }

    // Book seats by receiving a JSON array in the request body
    @PostMapping("/book")
    public String bookSeats(@RequestBody List<Integer> seatNumbers) {
        for (int seatNum : seatNumbers) {
            Mahesh seat = maheshRepo.findBySeatNumber(seatNum);
            if (seat != null) {
                seat.setStatus("BOOKED");
                maheshRepo.save(seat);
            } else {
                maheshRepo.save(new Mahesh(seatNum, "BOOKED"));
            }
        }
        return "Seat booked successfully";
    }
}
