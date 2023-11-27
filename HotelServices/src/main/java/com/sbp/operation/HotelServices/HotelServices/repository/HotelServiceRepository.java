package com.sbp.operation.HotelServices.HotelServices.repository;

import com.sbp.operation.HotelServices.HotelServices.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelServiceRepository extends JpaRepository<Hotel,String> {
}
