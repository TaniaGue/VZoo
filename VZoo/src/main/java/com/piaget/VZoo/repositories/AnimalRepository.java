package com.piaget.VZoo.repositories;

import com.piaget.VZoo.entities.Animal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findByName(String name);
    List<Animal> findBySpecies(String species);
    List<Animal> findBySound(String sound);
    Animal findById(long id);
}