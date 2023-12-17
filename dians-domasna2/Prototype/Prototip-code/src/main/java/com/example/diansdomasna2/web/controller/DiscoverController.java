package com.example.diansdomasna2.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("discover")
public class DiscoverController {
    @GetMapping
    public String getPage()
    {
        return "discover";
    }
}
