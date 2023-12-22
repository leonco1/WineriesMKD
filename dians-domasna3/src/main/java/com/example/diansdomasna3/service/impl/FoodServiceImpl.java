package com.example.diansdomasna3.service.impl;

import com.example.diansdomasna3.Model.Food;
import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.repository.jpa.FoodRepository;
import com.example.diansdomasna3.repository.jpa.WineRepository;
import com.example.diansdomasna3.service.FoodService;

import java.util.List;
import java.util.stream.Collectors;

public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final WineRepository wineRepository;

    public FoodServiceImpl(FoodRepository foodRepository, WineRepository wineRepository) {
        this.foodRepository = foodRepository;
        this.wineRepository = wineRepository;
    }

    @Override
    public List<Food> findAll() {
        return this.foodRepository.findAll();
    }

    @Override
    public List<Food> findAllById(Long id) {
        return this.foodRepository.findAllById(id);
    }
}
