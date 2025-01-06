package com.projects.veterinarian.controller;

import com.projects.veterinarian.entity.Pet;
import com.projects.veterinarian.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/pets")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    //adding a pet
    @PostMapping
    public void addPet(@RequestBody Pet pet){
        petService.addPets(pet);
    }

    // getting all the pets
    @GetMapping
    public List<Pet> getPets(){
        return petService.getPets();
    }

    // deleting a pet by id
    @DeleteMapping(path = "{Id}")
    public void deletePet(@PathVariable("Id") Long id){
        petService.deletePet(id);
    }

    @PutMapping(path = "{Id}")
    public void updatePet(@PathVariable("Id") Long id,@RequestBody Pet pet){
        petService.updatePet(id, pet);
    }

    @GetMapping(path = "{Id}")
    public Pet getPet(@PathVariable("Id") Long id){
        return petService.getPet(id);
    }
}
