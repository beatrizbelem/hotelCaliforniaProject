package com.hotelCalifornia.hotelCalifornia.infraestructure.repository;

import com.hotelCalifornia.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
    public interface HotelCaliforniaRepository extends JpaRepository<HotelCaliforniaModel, Long>{



}

