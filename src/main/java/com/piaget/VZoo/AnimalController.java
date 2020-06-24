
package com.piaget.VZoo;

import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.entities.Habitat;
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
import java.util.List;


@Controller
public class AnimalController {

    public static AnimalRepository animalRepository;

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


    @Autowired
    public AnimalController(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }

    @GetMapping("/createAnimal")
    public String showSignUpForm(Animal animal) {
        return "add-animal";
    }

    @PostMapping("/addAnimal")
    public String addAnimal(@Valid Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "createAnimal";
        }

        animalRepository.save(animal);
        model.addAttribute("animal", animalRepository.findAll());

        // obter todos os habitat
        List<Habitat> listHabitats = HabitatController.habitatRepository.findAll();
        animal.setHabitat(listHabitats.get(0));

        List<Animal> listAnimals = (List<Animal>) animalRepository.findAll();

        for (Animal listAnimal : listAnimals) {
            listAnimal.calculateSatisfaction();
        }

        animal.calculateSatisfaction();

        animalRepository.save(animal);

        calculateTotalSatisfaction(model);

        List<Habitat> habitatsAnimalPassed = animal.getAllHabitats();

        model.addAttribute("habitatsAnimalPassed", habitatsAnimalPassed);
        model.addAttribute("animals", animalRepository.findAll());

        return "animalPage";
    }


    @GetMapping("/deleteAnimal/{id}")
    public String deleteAnimal(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id);
        animalRepository.delete(animal);
        model.addAttribute("animals", animalRepository.findAll());
        return "animalPage";
    }

    private void calculateTotalSatisfaction(Model model) {
        List<Animal> listAnimals = (List<Animal>) animalRepository.findAll();

        int accumulatedSatisfaction = 0;

        for (Animal listAnimal : listAnimals) {
            listAnimal.calculateSatisfaction();
            accumulatedSatisfaction += listAnimal.getAnimalSatisfaction();

        }

        int allAnimals = listAnimals.size();

        double satisfactionMedia = accumulatedSatisfaction / allAnimals;

        model.addAttribute("totalSatisfaction", satisfactionMedia);
    }
}
