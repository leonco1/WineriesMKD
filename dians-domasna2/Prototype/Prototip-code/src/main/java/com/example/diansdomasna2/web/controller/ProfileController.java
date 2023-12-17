package com.example.diansdomasna2.web.controller;

import com.example.diansdomasna2.Model.User;
import com.example.diansdomasna2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getProfile(HttpServletRequest request, Model model)
    {

        User user=this.userService.find_By_username((String)request.getSession().getAttribute("username")).get();
        model.addAttribute("User",user);
        return "profile";
    }
}
