package com.sbp.operation.UserService.UserService.serviceImpl;

import com.sbp.operation.UserService.UserService.entity.Rating;
import com.sbp.operation.UserService.UserService.entity.User;
import com.sbp.operation.UserService.UserService.exception.UserServiceException;
import com.sbp.operation.UserService.UserService.external.service.HotelFeignService;
import com.sbp.operation.UserService.UserService.external.service.RatingFeignService;
import com.sbp.operation.UserService.UserService.model.Hotel;
import com.sbp.operation.UserService.UserService.repositories.UserServiceRepository;
import com.sbp.operation.UserService.UserService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

//    Logger logger = LoggerFactory.getLogger(UserServiceImpl.
//    class);

    @Autowired
    UserServiceRepository userServiceRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HotelFeignService hotelFeignService;

    @Autowired
    RatingFeignService ratingFeignService;
    @Override
    public User saveUser(User user) {
        String uniqueId = UUID.randomUUID().toString();
        user.setId(uniqueId);
        userServiceRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(String id) {
        User user = userServiceRepository.findById(id).orElseThrow(()->new UserServiceException("This user is not present !!"));
        //http://localhost:8093/rating/user/
        //restTemplate.getForObject("http://RATING-SERVICE/rating/user/".concat(id), Rating[].class);
        List<Rating> ratingList = ratingFeignService.getRatingOjectById(id);
        log.info("List Of Rating : {}",ratingList);
        List<Rating>  newratingList  = ratingList.stream().map(rating -> {
            //restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/".concat(rating.getHotelId()),
            // Hotel.class);
            Hotel hotel = hotelFeignService.getHotelById(rating.getHotelId()); //here using feignClient instead of RestTemplate
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(newratingList);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList =  userServiceRepository.findAll();
        return userList.stream().map(user-> {
//            restTemplate.getForObject("http://RATING-SERVICE/rating/user/"
//                    .concat(user.getId()),Rating[].class);
            List<Rating> ratingList = ratingFeignService.getRatingOjectById(user.getId());


            log.info("UserId: {}: Rating {}",user.getId(), ratingList);

            List<Rating> newRatingList = ratingList.stream().map(rating -> {
//                restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"
//                        .concat(rating.getHotelId()), Hotel.class);
                Hotel forEntity = hotelFeignService.getHotelById(rating.getHotelId());
                rating.setHotel(forEntity);
                return rating;
            }).collect(Collectors.toList());

            user.setRatings(newRatingList);
            return user;}).collect(Collectors.toList());

    }

    @Override
    public void deleteUserById(String id) {
        userServiceRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        User user1 = userServiceRepository.findById(user.getId()).orElseThrow(()->new UserServiceException("This user is not present !!"));
        user1.setName(user.getName());
        userServiceRepository.save(user1);
        return user1;
    }


}
