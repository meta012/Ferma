package exceptions;

/**
 * @throws animal age exception
 *
 */
public class AnimalAgeException extends FarmException {
    public AnimalAgeException(String message, Throwable cause) {
        super("Animal age out of bound: "+message, cause);
    }
}
