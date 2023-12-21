package com.example.diansdomasna3.web.controller;

import com.example.diansdomasna3.Model.User;
import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        List<Wine> wineList=(List<Wine>)request.getSession().getAttribute("WineList");
        model.addAttribute("User",user);
        model.addAttribute("WineList",wineList);
        return "profile";
    }
    @GetMapping("/edit-form")
    public String getEditForm(HttpServletRequest request,Model model)
    {
        User user=this.userService.find_By_username((String)request.getSession().getAttribute("username")).get();
        model.addAttribute("user",user);
        return "edit-profile";
    }
    @PostMapping("/edit-profile")
    public String EditProfile(@RequestParam String address,HttpServletRequest request)
    {
        User user=this.userService.find_By_username((String)request.getSession().getAttribute("username")).get();
            this.userService.editUser(user.getId(),address);
            return "redirect:/home";
    }
//    @PostMapping("/shopping-cart")
//    public String addWines()
}
