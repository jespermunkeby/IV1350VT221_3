package exceptionHandling;

/**
 * Thrown when calls to external system fails.
 */
public class NoResponseException extends RuntimeException {

    /**
     * Creates a new instance including a message and what system
     * that is not responding.
     */
    public NoResponseException(String db) {
        super("Call to \"%d\" failed.".formatted(db));
    }
}