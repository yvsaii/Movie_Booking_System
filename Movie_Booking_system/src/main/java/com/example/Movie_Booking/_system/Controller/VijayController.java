
package com.example.Movie_Booking._system.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/MultipleTheater/Vijay") // matches exactly what your HTML is calling
@CrossOrigin(origins = "http://localhost:5500") // change to your frontend port if different
public class VijayController {

    private final List<Seat> seats = new ArrayList<>();

    public VijayController() {
        for (int i = 1; i <= 80; i++) {
            seats.add(new Seat(i, "EMPTY"));
        }
    }

    @GetMapping("/seats")
    public List<Seat> getSeats() {
        return seats;
    }

    @PostMapping("/seats/book")
    public String bookSeats(@RequestBody List<Integer> seatNumbers) {
        for (Integer num : seatNumbers) {
            Seat seat = seats.stream()
                    .filter(s -> s.getSeatNumber() == num)
                    .findFirst()
                    .orElse(null);
            if (seat == null) {
                return "Seat " + num + " does not exist!";
            }
            if ("BOOKED".equalsIgnoreCase(seat.getStatus())) {
                return "Seat " + num + " is already booked!";
            }
            seat.setStatus("BOOKED");
        }
        return "Booking successful!";
    }

    // Simple Seat class
    static class Seat {
        private int seatNumber;
        private String status;

        public Seat(int seatNumber, String status) {
            this.seatNumber = seatNumber;
            this.status = status;
        }
        public int getSeatNumber() { return seatNumber; }
        public String getStatus() { return status; }
        public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
        public void setStatus(String status) { this.status = status; }
    }
}
