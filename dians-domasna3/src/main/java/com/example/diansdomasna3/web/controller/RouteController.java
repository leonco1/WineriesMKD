package com.example.diansdomasna3.web.controller;

import com.example.diansdomasna3.Model.Wineries;
import com.example.diansdomasna3.repository.jpa.FoodRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/route")
public class RouteController {

    @GetMapping
    public String getPage(HttpServletRequest request, Model model)
    {
        String username=(String)request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        Wineries wineries=(Wineries)request.getSession().getAttribute("winery");
        model.addAttribute("winery",wineries.getName());
        model.addAttribute("wines",wineries.getWines());
        return "route";
    }

}
