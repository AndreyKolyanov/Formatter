package ru.andrewkolyanov.machine.acts;

/**
 * The class describes an exception related to the inability to perform the action
 */
public class ActException extends Exception {
    /**
     * constructor
     * @param cause the inner exception
     */
    public ActException(Throwable cause) {
        super(cause);
    }
}
