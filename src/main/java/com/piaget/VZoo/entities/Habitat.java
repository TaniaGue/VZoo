package com.piaget.VZoo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Habitat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int area;
    private char image;


    @OneToMany
    private List<Animal> animal = new ArrayList<Animal>();

    public Habitat() { }

    public Habitat(String name, int area) {
        this.name = name;
        this.area = area;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimals(List<Animal> animal) {
        this.animal = animal;
    }

    public void addAnimal(Animal animal) {
        this.animal.add(animal);
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public char getImage() {
        return image;
    }

    public void setImage(char image) {
        this.image = image;
    }

}

