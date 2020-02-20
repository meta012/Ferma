package exceptions;

/**
 * Custom made exception class
 *
 */
public class FarmException extends Exception {  //extend excption, todel yra checked - reikia throw/ unchecked - extend Error/RuntimeException
    public FarmException(String message, Throwable cause) {

        super(message, cause);
    }
}
