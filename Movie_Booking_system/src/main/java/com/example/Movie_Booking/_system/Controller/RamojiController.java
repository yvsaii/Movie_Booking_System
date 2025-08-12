package com.example.Movie_Booking._system.Controller;

import com.example.Movie_Booking._system.Entity.Ramoji;
import com.example.Movie_Booking._system.Repo.RamojiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MultipleTheater/ramoji/seats")
@CrossOrigin(origins = "*")
public class RamojiController {

    @Autowired
    private RamojiRepo ramojiRepo;

    // Get all seats and their status
    @GetMapping
    public List<Ramoji> getAllSeats() {
        return ramojiRepo.findAll();
    }

    // Book seats by receiving a JSON array in the request body
    @PostMapping("/book")
    public String bookSeats(@RequestBody List<Integer> seatNumbers) {
        for (int seatNum : seatNumbers) {
            Ramoji seat = ramojiRepo.findBySeatNumber(seatNum);
            if (seat != null) {
                seat.setStatus("BOOKED");
                ramojiRepo.save(seat);
            } else {
                ramojiRepo.save(new Ramoji(seatNum, "BOOKED"));
            }
        }
        return "Seats booked successfully";
    }
}
