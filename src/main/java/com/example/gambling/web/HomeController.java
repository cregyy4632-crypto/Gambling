package com.example.gambling.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/blackjack")
    public String blackjack() {
        return "blackjack";
    }
    
    @GetMapping("/slot")
    public String slot() {
        return "slot";
    }
    
    @GetMapping("/roulette")
    public String roulette() {
        return "roulette";
    }
}



