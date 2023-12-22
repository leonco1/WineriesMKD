package com.example.diansdomasna3.service.impl;

import com.example.diansdomasna3.Model.Review;
import com.example.diansdomasna3.Model.Wine;
import com.example.diansdomasna3.repository.jpa.WineRepository;
import com.example.diansdomasna3.service.ReviewService;
import com.example.diansdomasna3.repository.jpa.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {


    private final ReviewRepository reviewRepository;
    private final WineRepository wineRepository;

    public ReviewServiceImpl( WineRepository wineRepository,ReviewRepository reviewRepository) {

        this.reviewRepository = reviewRepository;
        this.wineRepository=wineRepository;
    }

    @Override
    public void addReview(Long wineId, Integer score, String description) throws Exception {
        Wine wine = wineRepository.findById(wineId).orElseThrow(Exception::new);
        reviewRepository.save(new Review(score, description, wine));
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }


}
