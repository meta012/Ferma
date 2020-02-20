package products;

/**
 * Represents milk from our farm cows
 *
 */
public class Milk{
    private double litresOfMilk;
    public Milk(double litres) {
        this.litresOfMilk = litres;
    }
    public void setMilkQuantity(double litresOfMilk) {
        this.litresOfMilk = litresOfMilk;
    }
    public double getMilkQuantity() {

        return litresOfMilk;
    }
}
