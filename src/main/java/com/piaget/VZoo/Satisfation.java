
package com.piaget.VZoo;

import com.piaget.VZoo.entities.Animal;
import com.piaget.VZoo.entities.Habitat;

import java.util.List;

public class Satisfation {

    public static int calculate(Animal animalQueQuerSaberASatisfacao) {
        return 20 + igual(animalQueQuerSaberASatisfacao) - diferente(animalQueQuerSaberASatisfacao) + espaco(animalQueQuerSaberASatisfacao);
    }

    private static int igual(Animal animalQueQuerSaberQuantosAnimaisIguais)
    {
        Habitat habitatDoAnimalQueQuerSaberIguais = animalQueQuerSaberQuantosAnimaisIguais.getHabitat();
        List<Animal> animaisDoMesmoHabitat = habitatDoAnimalQueQuerSaberIguais.getAnimal();

        int contadorDeAnimaisDaMesmaEspecie = 0;

        for (Animal animalQueResideNoMesmoHabitat : animaisDoMesmoHabitat) {
            if (animalQueResideNoMesmoHabitat.getSpecie().equals(animalQueQuerSaberQuantosAnimaisIguais.getSpecie())) {
                contadorDeAnimaisDaMesmaEspecie++;
            }
        }

        // Não se conta com o próprio
        contadorDeAnimaisDaMesmaEspecie--;

        return 3 * contadorDeAnimaisDaMesmaEspecie;
    }

    private static int diferente(Animal animalQueQuerSaberDiferentes) {
        String especieDoAnimalOriginal = animalQueQuerSaberDiferentes.getSpecie();
        Habitat habitatDoAnimalOriginal = animalQueQuerSaberDiferentes.getHabitat();

        List<Animal> animaisDoMesmoHabitat = habitatDoAnimalOriginal.getAnimal();

        int contadorDeAnimaisDiferentes = 0;

        for (int i = 0; i < animaisDoMesmoHabitat.size(); i++) {
            Animal animalQueQueroComparar = animaisDoMesmoHabitat.get(i);
            String especieDoOutroAnimal = animalQueQueroComparar.getSpecie();

            if (!(especieDoAnimalOriginal.equals(especieDoOutroAnimal))) {
                contadorDeAnimaisDiferentes++;
            }
        }

        return 2 * contadorDeAnimaisDiferentes;
    }

    private static int espaco(Animal animalQueMoraNoHabitat) {
        // Saber o número de animais nesse Habitat - População
        // Arredondar (Area / População)

        Habitat habitatOndeMoraOAnimal = animalQueMoraNoHabitat.getHabitat();
        int areaDoHabitat = habitatOndeMoraOAnimal.getArea();
        int numeroDeAnimaisNoHabitat = habitatOndeMoraOAnimal.getAnimal().size();

        int arredondamento = Math.round(areaDoHabitat / numeroDeAnimaisNoHabitat);

        return  arredondamento;
    }
}
