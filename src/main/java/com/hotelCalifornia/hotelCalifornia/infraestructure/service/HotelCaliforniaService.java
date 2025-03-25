package com.hotelCalifornia.hotelCalifornia.infraestructure.service;

import com.hotelCalifornia.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import com.hotelCalifornia.hotelCalifornia.infraestructure.repository.HotelCaliforniaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelCaliforniaService {

    private final HotelCaliforniaRepository hotelCaliforniaRepository;

    public HotelCaliforniaService(HotelCaliforniaRepository hotelCaliforniaRepository) {
        this.hotelCaliforniaRepository = hotelCaliforniaRepository;
    }

    public List<HotelCaliforniaModel> findAll(){
        return hotelCaliforniaRepository.findAll();
    }

    public HotelCaliforniaModel create(HotelCaliforniaModel hotelCaliforniaModel){
        return hotelCaliforniaRepository.save(hotelCaliforniaModel);
    }

    public Optional<HotelCaliforniaModel> findById(Long id){
        return hotelCaliforniaRepository.findById(id);
    }

    public void deleteById(HotelCaliforniaModel hotelCaliforniaModel){
         hotelCaliforniaRepository.delete(hotelCaliforniaModel);
    }

    public boolean existsById(Long id){
        return hotelCaliforniaRepository.existsById(id);
    }









}
