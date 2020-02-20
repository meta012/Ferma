package customer;

/**
 * Represents farm customer
 *
 */
public class Customer {
    private String name;
    private double payment;
    private String bought;

    public Customer(String name, double payment, String bought) {
        this.name = name;
        this.payment = payment;
        this.bought = bought;
    }
    public String getName() {
        return this.name;
    }
    public double getPayment() {
        return this.payment;
    }
    public String getBought() {
        return this.bought;
    }
    public String toString() {
        return "\nPirkejas: "+getName()+ " sumokejo "+getPayment()+" eurus";
    }
}
