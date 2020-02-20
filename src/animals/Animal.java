package animals;

import exceptions.AnimalAgeException;

/**
 * Animal interface
 * 
 *
 */
public interface Animal extends Sellable {
    int getAge() throws AnimalAgeException;
}
