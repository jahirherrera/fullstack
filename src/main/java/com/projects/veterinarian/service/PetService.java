package com.projects.veterinarian.service;


import com.projects.veterinarian.entity.Pet;
import com.projects.veterinarian.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public void addPets(Pet pet){
        petRepository.save(pet);
    }

    public Pet getPet(Long id){
        return petRepository.findById(id).orElseThrow(()-> new IllegalStateException("NO PET FOUND"));
    }

    public void deletePet(Long id){
       boolean exist = petRepository.existsById(id);
        if(!exist) {
            throw new IllegalStateException("NO PET FOUND");
        }

        petRepository.deleteById(id);
    }


    public void updatePet(Long id, Pet pet){
        Pet pett = petRepository.findById(id).orElseThrow(()->new IllegalStateException("NO PET FOUND"));

        pett.setName(pet.getName());
        pett.setDescription(pet.getDescription());

        petRepository.save(pet);
    }



}
