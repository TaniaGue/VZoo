
package com.piaget.VZoo.repositories;

import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.entities.Habitat;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface HabitatRepository  extends CrudRepository<Habitat, Long> {
    List<Habitat> findByName(String name);
    List<Habitat> findByArea(String area);
    List<Habitat> findByImage(String image);
    Habitat findById(long id);
}
