package com.sbp.operation.UserService.UserService.external.service;

import com.sbp.operation.UserService.UserService.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingFeignService {

    @GetMapping("/rating/user/{ratingId}")
    List<Rating> getRatingOjectById(@PathVariable String ratingId);

    @PostMapping("/rating")
    Rating createRating(@RequestBody  Rating rating);
}
