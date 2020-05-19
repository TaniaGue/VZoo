package com.piaget.VZoo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String name;
    private char image;
    private String specie;
    private String sound;
    private int animalSatisfation;

    public Animal(String name, char image, String specie, String sound, int animalSatisfation) {
        this.name = name;
        this.image = image;
        this.specie = specie;
        this.sound = sound;
        this.animalSatisfation = animalSatisfation;
    }

    @Override
    public String toString() {
        return String.format(
                "Animal[id=%d, name='%s', specie='%s']",
                id, name, specie);
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

    public int getAnimalSatisfation() {
        return animalSatisfation;
    }

    public void setAnimalSatisfation(int animalSatisfation) {
        this.animalSatisfation = animalSatisfation;
    }
}
