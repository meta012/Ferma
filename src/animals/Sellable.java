package animals;

import exceptions.AnimalAgeException;

/**
 * Sellable interface
 *
 */
public interface Sellable {
    double getPrice() throws AnimalAgeException;
    boolean isSold();
    default double getPriceWithDiscount() throws AnimalAgeException{

        return getPrice()-getPrice()*0.1;
    }
}
