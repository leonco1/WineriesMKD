package com.example.diansdomasna3.web.controller;

import com.example.diansdomasna3.Model.Food;
import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.repository.jpa.FoodRepository;
import com.example.diansdomasna3.repository.jpa.WineRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {
   private final FoodRepository foodRepository;
   private final WineRepository wineRepository;

    public FoodController(FoodRepository foodRepository, WineRepository wineRepository) {
        this.foodRepository = foodRepository;
        this.wineRepository = wineRepository;
    }

    @GetMapping("/{id}")
    public String getFoodPage(@PathVariable Long id, Model model)
    {
        Wine wine=this.wineRepository.findById(id).get();
        List<Food>foods=wine.getFoods();
        model.addAttribute("foods",foods);
        model.addAttribute("wine",wine);
        return "food";
    }
}
