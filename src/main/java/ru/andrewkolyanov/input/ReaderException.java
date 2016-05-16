package ru.andrewkolyanov.input;

/**
 * class to describe the error
 */
public class ReaderException extends Exception {
    /**
     * constructor
     * @param cause the inner Exception
     */
    public ReaderException(final Throwable cause) {
        super(cause);
    }
}
