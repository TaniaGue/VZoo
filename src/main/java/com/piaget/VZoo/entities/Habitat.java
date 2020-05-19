package com.piaget.VZoo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habitat {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String name;
    private int area;
    private char image;

    public Habitat(String name, int area, char image) {
        this.name = name;
        this.area = area;
        this.image = image;
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


    @Override
    public String toString() {
        return String.format(
                "Habitat[id=%d, name='%s', area='%s', image='%s']",
                id, name, area, image);
    }
}

