package com.example.Movie_Booking._system.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Ntr")
public class Ntr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "seat_number", nullable = false, unique = true)
    private int seatNumber;

    @Column(name = "status", nullable = false)
    private String status;  // "EMPTY" or "BOOKED"

    public Ntr() {}

    public Ntr(int seatNumber, String status) {
        this.seatNumber = seatNumber;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
