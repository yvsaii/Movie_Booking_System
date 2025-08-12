package com.example.Movie_Booking._system.Controller;

import com.example.Movie_Booking._system.Entity.Login;
import com.example.Movie_Booking._system.Services.LoginSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/MultipleTheater")
public class RegisterControl {
    @Autowired
    private LoginSer loginSer;

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }

    @PostMapping("/register")
    public String registrationProcess(@RequestParam String email, @RequestParam String password, @RequestParam String username, RedirectAttributes redirectatt){
        if(loginSer.findingEmail(email)){
            redirectatt.addFlashAttribute("errorMessage","User Already exist");
            return "redirect:/MultipleTheater/register";
        } else{
            Login newUser= new Login();
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setUsername(username);
            loginSer.saveUser(newUser);
            redirectatt.addFlashAttribute("successMessage","Successfully Account created");
            return "redirect:/MultipleTheater/login";
        }
    }
}
