package com.piaget.VZoo;

import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.entities.Habitat;

import java.util.List;

public class Satisfation {
    public static int calculate (Animal animal){
        return 20 + igual(animal) - diferente(animal) + espaco(animal);
    }
    public static  int igual (Animal animal){
        Habitat habitat = animal.getHabitat();
        List<Animal> animals = habitat.getAnimal();

        int result = 0;
        for (Animal a : animals) {
            if (animal.getSpecie().EqualsTo(a.getSpecie())) {
                result++;
            }
        }

        return 3 * result;
    }
    public static int diferente (Animal animal){
        int result =0;
        return result;
    }

    public  static int espaço (Animal animal){
        int result =0;
        return result;
    }
}
