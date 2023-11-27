package com.sbp.operation.HotelServices.HotelServices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name="hotels")
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    String id;
    String name;
    String address;
    String about;
}
