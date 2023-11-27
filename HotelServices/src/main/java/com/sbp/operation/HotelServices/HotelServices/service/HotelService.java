package com.sbp.operation.HotelServices.HotelServices.service;

import com.sbp.operation.HotelServices.HotelServices.entity.Hotel;

import java.util.List;

public interface HotelService {
    //save
    Hotel saveHotelDetails(Hotel hotel);
    //getId

    Hotel getHotelDetailsById(String id);
    //getAll
    List<Hotel> getHotelDetails();
}
