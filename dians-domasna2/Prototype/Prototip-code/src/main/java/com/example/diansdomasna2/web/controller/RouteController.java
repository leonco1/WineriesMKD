package com.example.diansdomasna2.web.controller;

import com.example.diansdomasna2.Model.Wineries;
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
        model.addAttribute("winery",wineries);
        model.addAttribute("wines",wineries.getWines());
        return "route";
    }
    @GetMapping("Stobi")
    public String getStobi(HttpServletRequest request,Model model)
    {
        String username=(String)request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        return "winery";
    }
    @GetMapping("wine")
    public String getMerlot(HttpServletRequest request,Model model)
    {
        String username=(String)request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        return "wine";
    }
}
