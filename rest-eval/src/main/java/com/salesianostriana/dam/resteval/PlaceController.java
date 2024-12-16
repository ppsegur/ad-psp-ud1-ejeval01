package com.salesianostriana.dam.resteval;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {
    //Repositorio
    private PlaceRepository placeRepository;

    //cConstructor
    public PlaceController(PlaceRepository placeRepository, HttpSession httpSession) {
    }
    //Listar todos los bares
    @GetMapping("/")
    public List<Place> getall(){
       return  placeRepository.getAll();
    }

    //Crear un nuevo bar
    @PostMapping("/")
    public ResponseEntity<Place> create(@RequestBody Place place){
        return ResponseEntity.status(HttpStatus.CREATED).body(placeRepository.add(place));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Place> editById(@PathVariable Long id, @RequestBody Place p){
        if(placeRepository.get(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        placeRepository.edit(id, p);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    //eiminar un bar
    @DeleteMapping("/{id}")
    public ResponseEntity<Place> deleteById(@PathVariable Long id){
        placeRepository.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
