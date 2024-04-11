package com.kh.api.controller;

import com.kh.api.domain.Animal;
import com.kh.api.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class AnimalController {

    @Autowired
    private AnimalService service;

    @PostMapping("/animal")
    public ResponseEntity inset(@RequestBody Animal animal){
        service.insert(animal);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/animal")
    public ResponseEntity<List<Animal>> select(){
        List<Animal> list = service.select();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/animal/{no}")
    public ResponseEntity<Animal> select(@PathVariable("no") int no){
        Animal vo = service.select(no);
        return ResponseEntity.status(HttpStatus.OK).body(vo);
    }

    @PutMapping("/animal")
    public ResponseEntity update(@RequestBody Animal animal){
        service.update(animal);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/animal/{no}")
    public ResponseEntity delete(@PathVariable("no") int no){
        service.delete(no);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
