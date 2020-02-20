package animals;

import exceptions.AnimalAgeException;
import products.Milk;

/**
 * Represents a cloneable sellable cow
 *
 */
public class Cow extends Mammal implements Cloneable{

    private double matureHighQualityCowPrice = 650;
    private double matureLowQualityCowPrice = 200;
    private double youngCowPrice = 300;
    private boolean sold;
    private int age;
    private String quality;

    private Milk milk;

    public Cow() {
    }
    public Cow(boolean sold, int age) {
        this.sold = sold;
        this.age = age;
    }
    public Cow(boolean sold, int age, String quality) {
        this.sold = sold;
        this.age = age;
        this.quality = quality;
    }
    public Cow(boolean sold, int age, String quality, Milk milk) {
        this.sold = sold;
        this.age = age;
        this.quality = quality;
        this.milk = milk;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }
    @Override
    public boolean isProducingMilkForManufacturing() {

        return true;
    }

    @Override
    public int getAge() throws AnimalAgeException {

        if (age>=10) {
            throw new AnimalAgeException("animal too old", null);
        }
        else if(age<=0) {
            throw new AnimalAgeException("animal not born", null);
        }
        return this.age;
    }
    @Override
    public double getPrice()throws AnimalAgeException {

        if (isMilkable()&& getQuality().equals("high")) {
            return matureHighQualityCowPrice;
        }
        if (isMilkable()&& getQuality().equals("low")) {
            return matureLowQualityCowPrice;
        }
        else return youngCowPrice;
    }

    @Override
    public boolean isSold() {
        return sold;
    }

    public String getQuality() {

        return quality;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Cow cow = (Cow) super.clone();
        Milk milkClone = new Milk(this.milk.getMilkQuantity());
        cow.setMilk(milkClone);
        return cow;
    }
}
