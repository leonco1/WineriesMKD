package com.example.diansdomasna3.Model;

import com.example.diansdomasna3.Model.enumerations.FoodType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private FoodType foodType;
    private String Name;

    public Food(FoodType foodType, String name) {
        this.foodType = foodType;
        Name = name;
    }
@ManyToMany(mappedBy = "foods")
List<Wine>wines;
    public Food() {

    }
}
