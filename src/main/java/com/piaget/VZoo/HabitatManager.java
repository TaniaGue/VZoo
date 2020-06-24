package com.piaget.VZoo;

import com.piaget.VZoo.entities.Habitat;

public class HabitatManager {

    public HabitatPage createHabitat (String nome, int area, char image){
        HabitatPage habitat = new HabitatPage(nome, image, area);
        return habitat;
    }

    public HabitatPage ViewHabitat(String nome, int area, char imagem){
        HabitatPage habitat = new HabitatPage(nome, imagem, area);
        return habitat ;
    }
}