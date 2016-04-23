package ru.kolyanov.tables;

/**
 * class to describe error
 */
public class OffsetException extends Exception {
    /**
     * constructor
     * @param cause inner exception
     */
    public OffsetException(final Throwable cause) {
        super(cause);
    }
}
