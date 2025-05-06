package com.hotelCalifornia.hotelCalifornia.api.controller;
import com.hotelCalifornia.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import com.hotelCalifornia.hotelCalifornia.infraestructure.service.HotelCaliforniaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping({"/api/hotel"})

public class HotelCaliforniaController {

    private final HotelCaliforniaService hotelCaliforniaService;

    public HotelCaliforniaController(HotelCaliforniaService hotelCaliforniaService) {
        this.hotelCaliforniaService = hotelCaliforniaService;
    }

    @GetMapping(value = "/findAll")
    public List findAll(){
        return hotelCaliforniaService.findAll();
    }

    @PostMapping(value = "/create")
    public HotelCaliforniaModel create(@RequestBody HotelCaliforniaModel hotelCaliforniaModel) {
        return hotelCaliforniaService.create(hotelCaliforniaModel);
    }

    @GetMapping(value = "find/{id}")
    public ResponseEntity<HotelCaliforniaModel>findbyId(@PathVariable UUID id) {
        return hotelCaliforniaService.findById(id).map(hotel
                        -> ResponseEntity.ok().body(hotel))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable UUID id, @RequestBody HotelCaliforniaModel hotelCaliforniaModel) {
        if (hotelCaliforniaService.existsById(id)){
            hotelCaliforniaService.deleteById(hotelCaliforniaModel);
            return ResponseEntity.ok().body("Deletado com Sucesso!");
        }
            return ResponseEntity.notFound().build();
        }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") UUID id,
                                         @RequestBody HotelCaliforniaModel hotelcaliforniaModel) {

        Optional<HotelCaliforniaModel> hotelOptional = hotelCaliforniaService.findById(id);

        if (!hotelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel nao encontrado");
        }

        hotelCaliforniaService.create(hotelcaliforniaModel);
        return ResponseEntity.status(HttpStatus.OK).body(hotelcaliforniaModel);

    }
}


