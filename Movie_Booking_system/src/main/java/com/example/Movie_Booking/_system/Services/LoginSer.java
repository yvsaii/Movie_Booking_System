package com.example.Movie_Booking._system.Services;
import com.example.Movie_Booking._system.Entity.Login;
import com.example.Movie_Booking._system.Repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginSer {

    @Autowired
    private LoginRepo loginRepo;

    public boolean loginFunctionality(String email, String password){
        Optional<Login> user=loginRepo.findByEmailAndPassword(email,password);
        return user.isPresent();
    }

    public boolean findingEmail(String email){
        Optional<Login> user=loginRepo.findByEmail(email);
        return user.isPresent();
    }

    public void saveUser(Login user){
        loginRepo.save(user);
    }
}
