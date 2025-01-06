package com.projects.veterinarian.service;


import com.projects.veterinarian.entity.Owner;
import com.projects.veterinarian.repository.OwnerRepository;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }

    public void addOwner(Owner owner){
        ownerRepository.save(owner);
    }

    public void deleteOwner(Long id){
        boolean exist = ownerRepository.existsById(id);
        if(!exist){
           throw new IllegalStateException("NO OWNER FOUND");
        }
        ownerRepository.deleteById(id);
    }

    public Owner getOwner(Long id){
        Owner owner = ownerRepository.findById(id).orElseThrow(()-> new IllegalStateException("non found"));
        return owner;
    }


    public void updateOwner(Long id, Owner owner){
        Owner ownerr = ownerRepository.findById(id).orElseThrow(()-> new IllegalStateException("non found"));

        ownerr.setName(owner.getName());
        ownerr.setLastname(owner.getLastname());
        ownerr.setEmail(owner.getEmail());
        ownerr.setPhone(owner.getPhone());

        ownerRepository.save(ownerr);

    }
}
