package exception;

/**
 * User defined exception which is defined in this class
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class InvalidMap extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * This method throws user defined exception if map is invalid
     *
     * @param message - message related to exception
     */
    public InvalidMap(String message) {
        super(message);
    }
}

