package com.sbp.operation.HotelServices.HotelServices.controller;

import com.sbp.operation.HotelServices.HotelServices.entity.Hotel;
import com.sbp.operation.HotelServices.HotelServices.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService service;
    //create
    @PostMapping
    public ResponseEntity<Hotel> addHotelDetails(@RequestBody Hotel hotel) {
                return new ResponseEntity<>(service.saveHotelDetails(hotel),HttpStatus.CREATED);
    }
    //getId

    @GetMapping("{hotelId}")
    public ResponseEntity<Hotel> getHotelDetailsById(@PathVariable String hotelId) {
        return  ResponseEntity.status(HttpStatus.OK).body(service.getHotelDetailsById(hotelId));
    }

    //getAll
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotelDetails() {
        return  ResponseEntity.ok(service.getHotelDetails());
    }
}
