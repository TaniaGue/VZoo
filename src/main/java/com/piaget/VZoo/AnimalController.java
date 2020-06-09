
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

    @GetMapping("/signupAnimal")
    public String showSignUpForm(Animal animal) {
        return "add-animal";
    }

    @PostMapping("/addAnimal")
    public String addAnimal(@Valid Animal animal, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-animal";
        }

        animalRepository.save(animal);
        model.addAttribute("animals", animalRepository.findAll());

        // obter todos os animais
        List<Habitat> habitatsDaBaseDeDados = HabitatController.habitatRepository.findAll();
        animal.setHabitat(habitatsDaBaseDeDados.get(0));

        List<Animal> animaisDaBaseDeDados = (List<Animal>) animalRepository.findAll();

        for (Animal animalDaBaseDeDados : animaisDaBaseDeDados) {
            animalDaBaseDeDados.calculateSatisfaction();
        }

        animal.calculateSatisfaction();

        animalRepository.save(animal);

        calculateTotalSatisfaction(model);

        List<Habitat> habitatsPorOndeEsteAnimalPassou = animal.getAllHabitats();

        model.addAttribute("habitatsOndePassou", habitatsPorOndeEsteAnimalPassou);
        model.addAttribute("animals", animalRepository.findAll());

        return "animalPage";
    }



    @GetMapping("/deleteAnimal/{id}")
    public String deleteAnimal(@PathVariable("id") long id, Model model) {
        Animal animal = animalRepository.findById(id);
        animalRepository.delete(animal);
        model.addAttribute("animals", animalRepository.findAll());
        return "animalspage";
    }

    private void calculateTotalSatisfaction(Model model) {
        List<Animal> animaisDaBaseDeDados = (List<Animal>) animalRepository.findAll();

        int satisfacaoAcumulada = 0;

        for (Animal animalDaBaseDeDados : animaisDaBaseDeDados) {
            animalDaBaseDeDados.calculateSatisfaction();
            satisfacaoAcumulada += animalDaBaseDeDados.getAnimalSatisfation();

        }

        int numeroDeAnimais = animaisDaBaseDeDados.size();

        double mediaDaSatisfacao = satisfacaoAcumulada / numeroDeAnimais;

        model.addAttribute("totalSatisfaction", mediaDaSatisfacao);
    }
}







