package com.sbp.operation.RatingServices.impl;

import com.sbp.operation.RatingServices.entity.Rating;
import com.sbp.operation.RatingServices.exception.RatingServiceException;
import com.sbp.operation.RatingServices.repository.RatingServiceRepository;
import com.sbp.operation.RatingServices.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingServiceRepository repository;


    @Override
    public Rating createRating(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public Rating getByRatingId(String id) {
        return repository.findById(id).orElseThrow(() -> new RatingServiceException("No Rating is Available !!"));
    }

    @Override
    public List<Rating> getAllRating() {
        return repository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repository.findByUserId(userId).orElseThrow(() -> new RatingServiceException("No Rating is Available !!"));
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId).orElseThrow(() -> new RatingServiceException("No Rating is Available !!"));
    }
}
