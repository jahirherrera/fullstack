package com.projects.veterinarian.controller;

import com.projects.veterinarian.entity.Owner;
import com.projects.veterinarian.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public void addOwner(@RequestBody Owner owner){
        ownerService.addOwner(owner);
    }

    @GetMapping
    public List<Owner> getOwners(){
        return ownerService.getOwners();
    }

    @GetMapping(path = "{Id}")
    public Owner getOwner(@PathVariable("Id") Long id){
        return ownerService.getOwner(id);
    }

    @DeleteMapping(path = "{Id}")
    public void deleteOwner(@PathVariable("Id") Long id){
        ownerService.deleteOwner(id);
    }

    @PutMapping(path= "{Id}")
    public void updateStudent(@PathVariable("Id") Long id, @RequestBody Owner owner){
        ownerService.updateOwner(id, owner);
    }


}
