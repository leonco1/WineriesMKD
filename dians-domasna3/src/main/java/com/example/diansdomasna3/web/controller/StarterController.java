package com.example.diansdomasna3.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Starter")
public class StarterController {

@GetMapping
    public String getHomePage()
{
return "Starter";
}
@PostMapping("/login-start")
        public String getLoginPage()
{
    return "redirect:/login";
}
@PostMapping("/register-start")
    public String getRegisterPage()
{
    return "redirect:/register";
}
}
