package animals;

import exceptions.AnimalAgeException;

/**
 * Represents a sellable pig
 *
 */
public class Pig extends Mammal{

    private double matureHighQualityPigPrice = 400;
    private double matureLowQualityPigPrice = 260;
    private double youngPigPrice = 300;
    private boolean sold;
    private int age;
    private String quality;

    public Pig() {}
    public Pig(boolean sold, int age, String quality) {
        this.sold = sold;
        this.age = age;
        this.quality = quality;
    }

    @Override
    public boolean isProducingMilkForManufacturing() {

        return false;
    }

    @Override
    public int getAge() throws AnimalAgeException {
        if(age>=7) {
            throw new AnimalAgeException("animal too old", null);
        }
        else if(age<=0) {
            throw new AnimalAgeException("animal not born", null);
        }
        return this.age;
    }
    @Override
    public double getPrice() throws AnimalAgeException{

        if (getAge()>=1&& getQuality(quality).equals("high")) {
            return matureHighQualityPigPrice;
        }
        if (getAge()>=1&& getQuality(quality).equals("low")) {
            return matureLowQualityPigPrice;
        }
        else return youngPigPrice;
    }

    @Override
    public boolean isSold() {

        return sold;
    }
    public String getQuality(String quality) {

        return quality;
    }
}
