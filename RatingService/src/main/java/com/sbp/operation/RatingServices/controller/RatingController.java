package com.sbp.operation.RatingServices.controller;

import com.sbp.operation.RatingServices.entity.Rating;
import com.sbp.operation.RatingServices.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService service;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatingDetails(){
        return ResponseEntity.ok(service.getAllRating());
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> retreiveRatingById(@PathVariable String ratingId) {
        return ResponseEntity.ok(service.getByRatingId(ratingId));
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> retreiveRatingByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(service.getRatingByHotelId(hotelId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> retreiveRatingByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(service.getRatingByUserId(userId));
    }


}
