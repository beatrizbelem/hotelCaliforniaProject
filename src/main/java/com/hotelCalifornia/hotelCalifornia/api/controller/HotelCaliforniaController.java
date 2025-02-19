package com.hotelCalifornia.hotelCalifornia.api.controller;
import com.hotelCalifornia.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import com.hotelCalifornia.hotelCalifornia.infraestructure.repository.HotelCaliforniaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.yaml.snakeyaml.nodes.NodeId.mapping;

@RestController
@RequestMapping({"/api/hotel"})
@RequiredArgsConstructor



public class HotelCaliforniaController {

    private final HotelCaliforniaRepository hotelCaliforniaRepository;

    @GetMapping
    public List<?> findAll(                                          {
        return hotelCaliforniaRepository.findAll();
    }

    @PostMapping
    public HotelCaliforniaModel create(@RequestBody HotelCaliforniaModel hotelCaliforniaModel) {
        return hotelCaliforniaRepository.save(hotelCaliforniaModel);
    }

}
