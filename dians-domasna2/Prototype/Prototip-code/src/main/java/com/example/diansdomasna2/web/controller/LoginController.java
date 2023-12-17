package com.example.diansdomasna2.web.controller;

import com.example.diansdomasna2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
            public String getPage()
    {
        return "login";
    }
        @PostMapping
    public String login(HttpServletRequest request,@RequestParam String username,@RequestParam String password) {
            if (userService.Authenticate(username, password).isPresent()) {
                    request.getSession().setAttribute("username",username);
                return "redirect:/home";
            }
            else return "redirect:/login";
        }

}
