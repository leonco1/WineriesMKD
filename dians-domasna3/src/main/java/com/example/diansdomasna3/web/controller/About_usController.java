package com.example.diansdomasna3.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about_us")
public class About_usController {
    @GetMapping
    public String getPage(HttpServletRequest request,Model model)
    {
        String username=(String)request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        return "about_us";
    }
}
