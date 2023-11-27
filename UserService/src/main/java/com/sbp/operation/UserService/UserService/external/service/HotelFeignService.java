package com.sbp.operation.UserService.UserService.external.service;

import com.sbp.operation.UserService.UserService.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelFeignService {

    @GetMapping("/hotel/{hotelId}")
    Hotel getHotelById(@PathVariable String hotelId);
}
