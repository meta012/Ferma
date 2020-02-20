package animals;

import exceptions.AnimalAgeException;

/**
 * Abstract Mammal class
 *
 */
abstract class Mammal implements Animal{
    public abstract boolean isProducingMilkForManufacturing();
    boolean isMilkable() throws AnimalAgeException {
        return isProducingMilkForManufacturing() && getAge() >= 2;
    }
}
