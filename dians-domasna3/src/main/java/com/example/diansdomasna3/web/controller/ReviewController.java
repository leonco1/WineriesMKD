package com.example.diansdomasna3.web.controller;

import com.example.diansdomasna3.Model.Wineries;
import com.example.diansdomasna3.service.ReviewService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/review")

public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping("/add-review/{id}")
    public String reviewWine(@PathVariable(name = "id") Long id, HttpServletRequest request,Model model) {
        model.addAttribute("wineId", id);
        String username=(String)request.getSession().getAttribute("username");
        Wineries wineries=(Wineries)request.getSession().getAttribute("winery");
        model.addAttribute("winery",wineries);
        model.addAttribute("username",username);
        model.addAttribute("reviews",this.reviewService.findAll());
        return "add-review";
    }

    @PostMapping("/{id}")
    public String reviewWine(@PathVariable(name = "id") Long id,
                             @RequestParam(name = "score") Integer score,
                             @RequestParam(name = "description") String description) throws Exception {
        reviewService.addReview(id, score, description);
        return "redirect:/review";
    }

    @GetMapping
    public String getReviewPage(HttpServletRequest request,Model model) {
        String username=(String)request.getSession().getAttribute("username");
        Wineries wineries=(Wineries)request.getSession().getAttribute("winery");
        model.addAttribute("winery",wineries);
        model.addAttribute("username",username);
        model.addAttribute("reviews",this.reviewService.findAll());
        model.addAttribute("reviews", reviewService.findAll());
        return "reviews";
    }


}
