package ru.andrewkolyanov.machine.tables;

/**
 * describe exceptions in a tables
 */
public class TableException extends Exception {
    /**
     * constructor
     * @param cause the inner exception
     */
    public TableException(Throwable cause) {
        super(cause);
    }
}
