package com.example.diansdomasna3.repository.jpa;

import com.example.diansdomasna3.Model.Food;
import com.example.diansdomasna3.Model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food>findAllById(Long id);
}
