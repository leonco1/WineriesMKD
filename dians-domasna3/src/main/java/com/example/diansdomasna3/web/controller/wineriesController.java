package com.example.diansdomasna3.web.controller;

import com.example.diansdomasna3.Model.Wineries;
import com.example.diansdomasna3.service.WineryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/wineries")
public class wineriesController {
    private final WineryService wineryService;


    public wineriesController(WineryService wineryService) {
        this.wineryService = wineryService;

    }

    @GetMapping
    public String getWineries(HttpServletRequest request,Model model)  {
        String username=(String)request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        model.addAttribute("wineries",wineryService.getWineries());
        return "wineries";
    }
    @PostMapping
    public String Route(HttpServletRequest request, @RequestParam String Name, Model model)
    {
        Wineries wineries=wineryService.FindByName(Name);
        request.getSession().setAttribute("winery",wineries);
        return "redirect:/route";
    }

}
