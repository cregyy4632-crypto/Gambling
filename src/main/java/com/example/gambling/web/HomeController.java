package com.example.gambling.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "blackjack";
    }
    
    @GetMapping("/blackjack")
    public String blackjack() {
        return "blackjack";
    }
}



