package com.example.diansdomasna3.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String getPage(HttpServletRequest request,Model model)
    {
        String username=(String)request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        return "home";
    }
    @PostMapping
    public String ReturnHome()
    {
        return "home";
    }
    @PostMapping("/wineries-redirect")
            public String getWineries()
    {
        return "redirect:/wineries";
    }
    @PostMapping("/Profile-redirect")
    public String getProfiles()
    {
        return "redirect:/profile";
    }
    @PostMapping("/Discover-redirect")
    public String Discover()
    {
        return "redirect:/discover";
    }
    @PostMapping("/About-us-redirect")
    public String About_us()
    {
        return "redirect:/about_us";
    }
}
