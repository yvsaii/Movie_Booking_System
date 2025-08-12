package com.example.Movie_Booking._system.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mahesh")
public class Mahesh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment primary key
    private Long id;

    @Column(name = "seat_number", unique = true, nullable = false)
    private int seatNumber;

    @Column(name = "status")
    private String status;

    // Default constructor (required by JPA)
    public Mahesh() {
    }

    // Constructor with all fields except id (id is auto-generated)
    public Mahesh(int seatNumber, String status) {
        this.seatNumber = seatNumber;
        this.status = status;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    // No setter for id as it is auto-generated

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

    // Optional: override toString() for better logging/debugging

    @Override
    public String toString() {
        return "Mahesh{" +
                "id=" + id +
                ", seatNumber=" + seatNumber +
                ", status='" + status + '\'' +
                '}';
    }
}
