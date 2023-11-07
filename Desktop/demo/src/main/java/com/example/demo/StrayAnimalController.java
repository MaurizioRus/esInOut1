package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stray-animal")
public class StrayAnimalController {

    @Autowired
    private repo strayAnimalRepository;

    @PostMapping
    public StrayAnimal Create(@RequestBody StrayAnimal strayAnimal){
        return strayAnimalRepository.save(strayAnimal);
    }

    @GetMapping
    public Iterable<StrayAnimal> getStrayAnimal(){
        return strayAnimalRepository.findAll();
    }
}
