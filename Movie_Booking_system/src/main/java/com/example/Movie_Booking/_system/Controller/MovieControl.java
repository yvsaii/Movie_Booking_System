package com.example.Movie_Booking._system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/MultipleTheater")
public class MovieControl {

    @GetMapping("/ramoji")
    public String RamojiScreen(){
        return "ramoji";
    }

    @GetMapping("/Vijay")
    public String VijayScreen(){
        return "vijay";
    }

    @GetMapping("/ntr")
    public String NtrScreen(){
        return "ntr";
    }


    @GetMapping("/mahesh")
    public String Mahesh(){
        return "mahesh";
    }

}
