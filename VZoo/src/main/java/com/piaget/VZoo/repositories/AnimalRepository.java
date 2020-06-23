package com.piaget.VZoo.repositories;

import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.entities.Habitat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
   // List<Animal> findByName(String name);
    //List<Animal> findBySpecie(String specie);
   // List<Animal> findBySound(String sound);
   // List<Animal> findBySound(Habitat habitat);
   // List<Animal> findBySound(int satisfaction);
    Animal findById(long id);
}
