package com.example.diansdomasna3.web.controller;

import com.example.diansdomasna3.service.AdminService;
import com.example.diansdomasna3.service.UserService;
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
    private final AdminService adminService;

    public LoginController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
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
            if(adminService.Authenticate(username,password).isPresent())
            {
                request.getSession().setAttribute("admin",username);
                return "redirect:/home";
            }
            else return "redirect:/login";
        }

}
