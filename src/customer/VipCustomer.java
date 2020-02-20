package customer;

/**
 * Represents VIP, a frequent customer
 *
 */
public class VipCustomer extends Customer {
    private String name;
    private double payment;
    private String bought;
    public VipCustomer(String name, double payment, String bought) {
        super(name, payment, bought);
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }
    public double getPayment() {
        return this.payment;
    }
    public void setBought(String bought) {
        this.bought = bought;
    }
    public String toString() {
        return "\nVIP pirkejas: "+super.getName()+ " is viso sumokejo "+super.getPayment()+" eurus";
    }
}
