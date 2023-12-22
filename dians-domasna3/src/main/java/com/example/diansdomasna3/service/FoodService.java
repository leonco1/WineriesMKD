package com.example.diansdomasna3.service;

import com.example.diansdomasna3.Model.Food;
import com.example.diansdomasna3.Model.Wine;

import java.util.List;

public interface FoodService {

    List<Food>findAll();
    List<Food>findAllById(Long id);
}
