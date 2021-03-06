
package com.piaget.VZoo;

import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.entities.Habitat;
import com.piaget.VZoo.repositories.HabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public static HabitatRepository habitatRepository;

    @Autowired
    public HabitatController(HabitatRepository repository) {
        this.habitatRepository = repository;
    }


    @GetMapping("/createHabitat")
    public String showSignUpForm(Habitat habitat) {
        return "add-habitat";
    }


    @GetMapping ("/addHabitat")
    public String addHabitat(@Valid Habitat habitat, BindingResult result, Model model) {
        if (result.hasErrors()) {

            return "createHabitat";
        }

        habitatRepository.save(habitat);
        model.addAttribute("habitat", habitatRepository.findAll());
        return "habitatPage";
    }

    @GetMapping("/editHabitat/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Habitat habitat = habitatRepository.findById(id);
        model.addAttribute("habitat", habitat);
        return "update-habitat";
    }

    @PostMapping("/updateHabitat/{id}")
    public String updateHabitat(@PathVariable("id") long id, @Valid Habitat habitat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            habitat.setId(id);
            return "update-habitat";
        }

        habitatRepository.save(habitat);
        model.addAttribute("habitat", habitatRepository.findAll());
        return "habitatPage";
    }

    @GetMapping("/deleteHabitat/{id}")
    public String deleteHabitat(@PathVariable("id") long id, Model model) {
        Habitat habitat = habitatRepository.findById(id);
        habitatRepository.delete(habitat);
        model.addAttribute("habitat", habitatRepository.findAll());
        return "habitatPage";
    }
    @GetMapping("/habitatPage")
    public String habitats(Model model)
    {
        return "habitatPage";
    }

    @PostMapping("/habitatPage")
    public String goToHabitats(Model model)
    {
        return "habitatPage";
    }

}