package com.piaget.VZoo;

import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.repositories.AnimalRepository;
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
public class AnimalController {

    @GetMapping("/animalPage")
    public String animal(Model model)
    {
        return "animalPage";
    }

    @PostMapping("/animalPage")
    public String goToAnimal(Model model)
    {
        return "animalPage";
    }

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalController(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    @GetMapping ("/addAnimal")
    public String addAnimal(@Valid Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addAnimal";
        }

        animalRepository.save(animal);
        model.addAttribute("animals", animalRepository.findAll());
        return "animalPage";
    }
}
