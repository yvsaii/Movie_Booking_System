package com.example.Movie_Booking._system.Dto;  // choose your package

import java.util.List;

public class BookingRequest {
    private List<Integer> seatNumbers;  // list of seat numbers booked
    private String screenName;           // name of the screen

    public BookingRequest() {}

    // Getters and Setters
    public List<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<Integer> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}
