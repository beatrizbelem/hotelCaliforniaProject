package com.hotelCalifornia.hotelCalifornia.api.controller;
import com.hotelCalifornia.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import com.hotelCalifornia.hotelCalifornia.infraestructure.service.HotelCaliforniaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/hotel"})
//@RequiredArgsConstructor

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
    public ResponseEntity<HotelCaliforniaModel>findbyId(@PathVariable Long id) {
        return hotelCaliforniaService.findById(id).map(hotel
                        -> ResponseEntity.ok().body(hotel))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?>deleteById(@PathVariable Long id, @RequestBody HotelCaliforniaModel hotelCaliforniaModel) {
        if (hotelCaliforniaService.existsById(id)){
            hotelCaliforniaService.deleteById(hotelCaliforniaModel);
            return ResponseEntity.ok().body("Deletado com Sucesso!");
        }
            return ResponseEntity.notFound().build();
        }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<HotelCaliforniaModel>updateById(@PathVariable Long id, @RequestBody HotelCaliforniaModel hotelCaliforniaModel) {
        return hotelCaliforniaService.findById(id).map(hotel -> {
                    hotel.setNome(hotelCaliforniaModel.getNome());
                    hotel.setLocal(hotelCaliforniaModel.getLocal());
                    hotel.setCapacidade(hotelCaliforniaModel.getCapacidade());

            return ResponseEntity.ok(hotelCaliforniaService.create(hotel));

        }).orElse(ResponseEntity.notFound().build());
    }
}


