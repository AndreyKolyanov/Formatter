package ru.kolyanov.output;

/**
 * class to describe errors
 */
public class WritingException extends Exception {
    /**
     * constructor
     * @param cause inner exception
     */
    public WritingException(final Throwable cause) {
        super(cause);
    }
}
