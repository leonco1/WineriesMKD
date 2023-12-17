package com.example.diansdomasna3.web.controller;

import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.Model.Wineries;
import com.example.diansdomasna3.Model.enumerations.WineType;
import com.example.diansdomasna3.service.AdminService;
import com.example.diansdomasna3.service.UserService;
import com.example.diansdomasna3.service.WineService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/Winery")
public class WineryController {
    WineService wineService;
    private final UserService userService;
    private final AdminService adminService;
    public WineryController(WineService wineService, UserService userService, AdminService adminService) {
        this.wineService = wineService;
        this.userService = userService;
        this.adminService = adminService;
    }

    @GetMapping()
    public String getStobi(HttpServletRequest request, Model model)
    {
        String username=(String)request.getSession().getAttribute("username");
        String admin=(String)request.getSession().getAttribute("admin");
        if(this.userService.find_By_username(username).isPresent())
            model.addAttribute("username",username);
         if(this.adminService.find_By_username(admin).isPresent())
            model.addAttribute("admin",admin);
        Wineries wineries=(Wineries)request.getSession().getAttribute("winery");
        model.addAttribute("wineries",wineries);

        return "winery";
    }
    @GetMapping("wine/{id}")
    public String getMerlot(@PathVariable Long id, HttpServletRequest request,Model model)
    {
        String username=(String)request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        Wine wine=this.wineService.findById(id).get();
        model.addAttribute("wine",wine);
        return "wine";
    }
    @GetMapping("/edit-form/{id}")
    public String editPage(@PathVariable Long id,Model model)
    {
        Optional<Wine>  wine=this.wineService.findById(id);
            if(wine.isPresent())
            {
                model.addAttribute(wine.get());
                return "edit-wine";
            }
            return "redirect:winery";

    }
    @GetMapping("/add-form")
    public String addWinePage(Model model)
    {
        return "add-wine";
    }
    @GetMapping("/delete/{id}")
            public String deleteWine(@PathVariable Long id)
    {
        this.wineService.deleteWine(id);
        return "redirect:/wineries";
    }
    @PostMapping("/add")
            public String saveWine(@RequestParam String name,@RequestParam WineType type,@RequestParam int price,@RequestParam LocalDate date,@RequestParam int size,HttpServletRequest request,Model model)
    {
        Wineries wineries=(Wineries)request.getSession().getAttribute("winery");
            this.wineService.addWine(name,type,price,date,size,wineries);

        return "redirect:/wineries";
    }
    @PostMapping("edit-wine/{id}")
    public String EditWine(@PathVariable Long id,@RequestParam int price,@RequestParam int size,HttpServletRequest request)
    {
        Wineries wineries=(Wineries)request.getSession().getAttribute("winery");
        Wine wine=this.wineService.findById(id).get();
        this.wineService.editWine(id,price,size);
        return "redirect:/wineries";
    }

}
