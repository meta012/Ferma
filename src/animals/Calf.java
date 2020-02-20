package animals;

import exceptions.AnimalAgeException;

/**
 * Represents an ungrown cow
 *
 */
public class Calf extends Mammal{

    private Cow cow;

    public Calf(boolean sold, int age) {
        cow = new Cow(sold, age);

    }
    @Override
    public boolean isProducingMilkForManufacturing() {
        return false;
    }

    @Override
    public int getAge() throws AnimalAgeException {
        return cow.getAge();
    }

    @Override
    public double getPrice() throws AnimalAgeException{
        return cow.getPrice();
    }

    @Override
    public boolean isSold() {
        return cow.isSold();
    }
}
