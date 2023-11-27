package com.sbp.operation.HotelServices.HotelServices.impl;

import com.sbp.operation.HotelServices.HotelServices.entity.Hotel;
import com.sbp.operation.HotelServices.HotelServices.exception.HotelServiceException;
import com.sbp.operation.HotelServices.HotelServices.repository.HotelServiceRepository;
import com.sbp.operation.HotelServices.HotelServices.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelServiceRepository hotelServiceRepository;


    @Override
    public Hotel saveHotelDetails(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        return hotelServiceRepository.save(hotel);
    }

    @Override
    public Hotel getHotelDetailsById(String id) {
        return hotelServiceRepository.findById(id).orElseThrow(() -> new HotelServiceException("Hotel is not available".concat(id)));
    }

    @Override
    public List<Hotel> getHotelDetails() {
        return hotelServiceRepository.findAll();
    }
}
