package com.sbp.operation.RatingServices.repository;

import com.sbp.operation.RatingServices.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RatingServiceRepository extends MongoRepository<Rating, String> {
    Optional<List<Rating>> findByUserId(String userId);

    Optional<List<Rating>> findByHotelId(String hotelId);
}
