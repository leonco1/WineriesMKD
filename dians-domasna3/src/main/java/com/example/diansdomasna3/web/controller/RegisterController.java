package com.example.diansdomasna3.web.controller;

import com.example.diansdomasna3.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getPage()
    {
        return "register";
    }
    @PostMapping
    public String registerUser(@RequestParam String Name,@RequestParam String Surname,@RequestParam String Username,@RequestParam String Password,@RequestParam String Address,@RequestParam String DateOfBirth)
    {
        userService.Register(Name,Surname,Username,Password,Address, DateOfBirth);
        return "redirect:/login";
    }
}
