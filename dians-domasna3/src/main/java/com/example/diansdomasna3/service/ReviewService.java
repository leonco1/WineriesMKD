package com.example.diansdomasna3.service;


import com.example.diansdomasna3.Model.Review;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


public interface ReviewService {

    void addReview(Long wineId, Integer score, String description) throws Exception;

    List<Review> findAll();


}
