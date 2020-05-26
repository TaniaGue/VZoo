package com.piaget.VZoo;

import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.entities.Habitat;

public class Satisfation {
    public static int calculate (Animal animal){
        return 20 + igual (animal) - diferente (animal) + espaço (animal);
    }

    public static  int igual (Animal animal){
        Habitat habitat = animal.getHabitat();
       // Animal animal = habitat.getAnimal();

        int result =0;
      //  for ( (Animal anim : animal)){
      //      if (animal.getSpecie().EqualsTo(animal.getSpecie())){

        //    }
        //}
        return result;
    }public static int diferente (Animal animal){
        int result =0;
        return result;
    }

    public  static int espaço (Animal animal){
        int result =0;
        return result;
    }
}
