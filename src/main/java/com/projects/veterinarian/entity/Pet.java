package com.projects.veterinarian.entity;


import jakarta.persistence.*;

@Entity
@Table
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String race;
    private String description;
    @ManyToOne
    private Owner owner;

    public Pet() {
    }

    public Pet(Long id, String name, String race, String description, Owner owner) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.description = description;
        this.owner = owner;
    }

    public Pet(String name, String race, String description, Owner owner) {
        this.name = name;
        this.race = race;
        this.description = description;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                '}';
    }
}
