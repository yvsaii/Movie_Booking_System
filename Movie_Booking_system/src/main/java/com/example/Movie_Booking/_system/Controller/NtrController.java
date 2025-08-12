package com.example.Movie_Booking._system.Controller;

import com.example.Movie_Booking._system.Entity.Ntr;
import com.example.Movie_Booking._system.Repo.NtrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/MultipleTheater/NTR/seats")
@CrossOrigin(origins = "*")  // Allow all origins for testing (adjust in prod)
public class NtrController {

    @Autowired
    private NtrRepo ntrRepo;

    // Get all seats with status (EMPTY or BOOKED)
    @GetMapping
    public List<Ntr> getAllSeats() {
        return ntrRepo.findAll();
    }

    // Book seats - accept list of seat numbers
    @PostMapping("/book")
    public ResponseEntity<String> bookSeats(@RequestBody List<Integer> seatNumbers) {
        List<Ntr> seatsToBook = seatNumbers.stream()
                .map(ntrRepo::findBySeatNumber)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        for (Ntr seat : seatsToBook) {
            if ("BOOKED".equalsIgnoreCase(seat.getStatus())) {
                return ResponseEntity.badRequest()
                        .body("Seat " + seat.getSeatNumber() + " is already booked.");
            }
            seat.setStatus("BOOKED");
        }

        ntrRepo.saveAll(seatsToBook);
        return ResponseEntity.ok("Seats booked successfully!");
    }
}
