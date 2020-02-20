package utils;

import animals.Animal;
import animals.Cow;
import animals.Pig;

/**
 * Represents method-factory to make new animal - either Pig or Cow
 *
 */
public class AnimalFactory {

    public static Animal create(String animalType) {
        if(animalType.equalsIgnoreCase("Cow")) {
            return new Cow();
        }
        else if (animalType.equalsIgnoreCase("Pig")) {
            return new Pig();
        }
        return null;
    }
}
