package com.hotelCalifornia.hotelCalifornia.api.controller;
import com.hotelCalifornia.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import com.hotelCalifornia.hotelCalifornia.infraestructure.repository.HotelCaliforniaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

import static org.yaml.snakeyaml.nodes.NodeId.mapping;

@RestController
@RequestMapping({"/api/hotel"})
//@RequiredArgsConstructor



public class HotelCaliforniaController {

    private final HotelCaliforniaRepository hotelCaliforniaRepository;

    public HotelCaliforniaController(HotelCaliforniaRepository hotelCaliforniaRepository) {
        this.hotelCaliforniaRepository = hotelCaliforniaRepository;
    }

    @PostMapping
    public HotelCaliforniaModel create(@RequestBody HotelCaliforniaModel hotelCaliforniaModel) {
        return hotelCaliforniaRepository.save(hotelCaliforniaModel);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<HotelCaliforniaModel>findbyId(@PathVariable Long id) {
        return hotelCaliforniaRepository.findById(id).map(hotel
                        -> ResponseEntity.ok().body(hotel))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id) {
        if (hotelCaliforniaRepository.existsById(id)){
            hotelCaliforniaRepository.deleteById(id);
            return ResponseEntity.ok().body("Deletado com Sucesso!");
        }
            return ResponseEntity.notFound().build();
        }

    @PutMapping(value = "{id}")
    public ResponseEntity<HotelCaliforniaModel>updateById(@PathVariable Long id, @RequestBody HotelCaliforniaModel hotelCaliforniaModel) {
        return hotelCaliforniaRepository.findById(id).map(hotel -> {
                    hotel.setNome(hotelCaliforniaModel.getNome());
                    hotel.setLocal(hotelCaliforniaModel.getLocal());
                    hotel.setCapacidade(hotelCaliforniaModel.getCapacidade());

            return ResponseEntity.ok(hotelCaliforniaRepository.save(hotel));

        }).orElse(ResponseEntity.notFound().build());
    }
}


