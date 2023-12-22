package com.example.diansdomasna3.Model;

import com.example.diansdomasna3.Model.enumerations.WineType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Wine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    private String name;
    private WineType wineType;
    int price;
 @DateTimeFormat(pattern = "dd-MM-yyyy")
 private LocalDate year;
    private int size;

    public Wine(String name, WineType wineType, int price, LocalDate year, int size, Wineries winery) {
        this.name = name;
        this.wineType = wineType;
        this.price = price;
        this.year = year;
        this.size = size;
        this.winery = winery;
    }
    public Wine(String name, WineType wineType, int price, LocalDate year, int size, Wineries winery,List<Food>foods) {
        this.name = name;
        this.wineType = wineType;
        this.price = price;
        this.year = year;
        this.size = size;
        this.winery = winery;
        this.foods=foods;
    }

    @ManyToOne
    @JoinColumn(name = "winery_Name")
    Wineries winery;
    @ManyToOne
    User user;
    @OneToMany(mappedBy = "review_wine")
    List<Review> reviewList;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
            @JoinTable(name = "food_reccomend",
            joinColumns = @JoinColumn(name = "food_id"),
            inverseJoinColumns = @JoinColumn(name = "wine_id"))
    List<Food>foods;
    public Wine() {

    }
}
