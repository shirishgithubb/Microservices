package com.sbp.operation.RatingServices.service;

import com.sbp.operation.RatingServices.entity.Rating;
import com.sbp.operation.RatingServices.repository.RatingServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {


    //create
    Rating createRating(Rating rating);
    //findById

    Rating getByRatingId(String id);

    //findAll
    List<Rating> getAllRating();

    //findByUserID
    List<Rating> getRatingByUserId(String userId);

    //findByHotelId

    List<Rating> getRatingByHotelId(String hotelId);


}
