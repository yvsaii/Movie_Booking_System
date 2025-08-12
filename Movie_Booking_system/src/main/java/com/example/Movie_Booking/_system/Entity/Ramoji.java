package com.example.Movie_Booking._system.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ramoji") // lowercase table name is safer in some DBs
public class Ramoji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number", nullable = false)
    private int seatNumber;

    @Column(name = "status", nullable = false)
    private String status;

    public Ramoji() {}

    public Ramoji(int seatNumber, String status) {
        this.seatNumber = seatNumber;
        this.status = status;
    }

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
