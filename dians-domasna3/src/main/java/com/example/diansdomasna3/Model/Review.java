package com.example.diansdomasna3.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    private String description;

    @ManyToOne
    private Wine review_wine;

    public Review(Integer score, String description, Wine review_wine) {
        this.score = score;
        this.description = description;
        this.review_wine= review_wine;
    }

    public Review() {

    }

    }
