package com.example.Movie_Booking._system.Controller;
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
public class LoginControl {

    @Autowired
    private LoginSer loginSer;

    @GetMapping("/")
    public String loginRedirect(){
        return "redirect:/MultipleTheater/login";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }

    @GetMapping("/movies")
    public String moviePage(){
        return "movies";
    }

    @GetMapping("/history")
    public String historyPage(){
        return "history";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectatt){
        if(loginSer.loginFunctionality(username,password)){
            redirectatt.addFlashAttribute("successMessage","Successfully Login!");
            return "redirect:/MultipleTheater/home";
        } else{
            redirectatt.addFlashAttribute("errorMessage","Invalid Details");
            return "redirect:/MultipleTheater/login";
        }
    }

}
