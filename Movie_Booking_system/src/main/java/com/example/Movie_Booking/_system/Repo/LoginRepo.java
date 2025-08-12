package com.example.Movie_Booking._system.Repo;
import com.example.Movie_Booking._system.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LoginRepo extends JpaRepository<Login, String> {

    Optional<Login> findByEmailAndPassword(String email,String password);
    Optional<Login> findByEmail(String emial);
}
