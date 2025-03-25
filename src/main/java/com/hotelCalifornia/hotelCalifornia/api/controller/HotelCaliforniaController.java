package com.hotelCalifornia.hotelCalifornia.api.controller;
import com.hotelCalifornia.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import com.hotelCalifornia.hotelCalifornia.infraestructure.repository.HotelCaliforniaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping({"/api/hotel"})
//@RequiredArgsConstructor

public class HotelCaliforniaController {

    private final HotelCaliforniaRepository hotelCaliforniaRepository;

    public HotelCaliforniaController(HotelCaliforniaRepository hotelCaliforniaRepository) {
        this.hotelCaliforniaRepository = hotelCaliforniaRepository;
    }

    @GetMapping(value = "/findAll")
    public List findAll(){
        return hotelCaliforniaRepository.findAll();
    }

    @PostMapping(value = "/create")
    public HotelCaliforniaModel create(@RequestBody HotelCaliforniaModel hotelCaliforniaModel) {
        return hotelCaliforniaRepository.save(hotelCaliforniaModel);
    }

    @GetMapping(value = "find/{id}")
    public ResponseEntity<HotelCaliforniaModel>findbyId(@PathVariable UUID id) {
        return hotelCaliforniaRepository.findById(id).map(hotel
                        -> ResponseEntity.ok().body(hotel))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable UUID id) {
        if (hotelCaliforniaRepository.existsById(id)){
            hotelCaliforniaRepository.deleteById(id);
            return ResponseEntity.ok().body("Deletado com Sucesso!");
        }
            return ResponseEntity.notFound().build();
        }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<HotelCaliforniaModel>updateById(@PathVariable UUID id, @RequestBody HotelCaliforniaModel hotelCaliforniaModel) {
        return hotelCaliforniaRepository.findById(id).map(hotel -> {
                    hotel.setNome(hotelCaliforniaModel.getNome());
                    hotel.setLocal(hotelCaliforniaModel.getLocal());
                    hotel.setCapacidade(hotelCaliforniaModel.getCapacidade());

            return ResponseEntity.ok(hotelCaliforniaRepository.save(hotel));

        }).orElse(ResponseEntity.notFound().build());
    }
}


