package com.piaget.VZoo;

import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.entities.Habitat;
import com.piaget.VZoo.repositories.AnimalRepository;
import com.piaget.VZoo.repositories.EmployeeRepository;
import com.piaget.VZoo.repositories.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HabitatController {
    private HabitatRepository habitatRepository;

    @Autowired
    public HabitatController(HabitatRepository repository) {
        this.habitatRepository = repository;
    }


    @GetMapping("/createHabitat")
    public String createHabitat(Habitat habitat) {
        return "createHabitat";
    }



    @GetMapping ("/addHabitat")
    public String addHabitat(@Valid Habitat habitat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addHabitat";
        }

        habitatRepository.save(habitat);
        model.addHabitat("habitat", habitatRepository.findAll());
        return "habitatPage";
    }

}
