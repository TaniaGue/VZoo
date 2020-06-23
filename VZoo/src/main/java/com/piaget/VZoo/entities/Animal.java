package com.piaget.VZoo.entities;
import com.piaget.VZoo.Satisfaction;
import com.piaget.VZoo.Satisfaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Animal {


        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private long id;
        private String name;
        private char image;
        private String specie;
        private String sound;
        private int animalSatisfaction;



    @OneToMany
    private List<Habitat> habitat = new ArrayList<>();

    protected Animal() {}

    public Animal(String name, String species) {
        this.name = name;
        this.specie = species;
    }


        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public char getImage() {
            return image;
        }

        public void setImage(char image) {
            this.image = image;
        }

        public String getSpecie() {
            return specie;
        }

        public void setSpecie(String specie) {
            this.specie = specie;
        }

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }


        public Habitat getHabitat() {
            return this.habitat.get(this.habitat.size() - 1);
         }

         public void setHabitat(Habitat habitat) {
            this.habitat.add(habitat);
            habitat.addAnimal(this);
        }

        public int getAnimalSatisfaction() {
            return getAnimalSatisfaction();
        }

        public void setAnimalSatisfaction(int animalSatisfaction) {
            this.animalSatisfaction = animalSatisfaction;
        }


     public List<Habitat> getAllHabitats() {
    return (List<Habitat>) this.habitat;
}

    @Override
    public String toString() {
        return String.format(
                "Animal[id=%d, name='%s', specie='%s']",
                id, name, specie);
    }
    public void calculateSatisfaction() {
        animalSatisfaction = Satisfaction.calculate(this);
    }
}
