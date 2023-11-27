package com.sbp.operation.UserService.UserService;

import com.sbp.operation.UserService.UserService.entity.Rating;
import com.sbp.operation.UserService.UserService.external.service.RatingFeignService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	RatingFeignService service;

	@Test
	void createRatingServiceUsingFeign() {
		Rating rating = new Rating().builder().ratingId(UUID.randomUUID().toString()).userId(UUID.randomUUID().toString())
						.rating(6).feedback("This feedback has created by Feign Client").build();
		service.createRating(rating);
	}

}
