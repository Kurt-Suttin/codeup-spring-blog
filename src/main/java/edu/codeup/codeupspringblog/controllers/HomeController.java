package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

//    @GetMapping("/")
//    @ResponseBody
//    public String landingPage() {
//        return "This is the landing page";
//    }

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort,Model model){
        model.addAttribute("cohort","welcome to "+cohort+ "!");
        return "join";
    }
}
