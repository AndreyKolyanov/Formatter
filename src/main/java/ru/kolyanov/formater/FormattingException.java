package ru.kolyanov.formater;
/**
 * class to describe the error
 */
public class FormattingException extends Exception {
    /**
     * constructor
     * @param cause the inner Exception
     */
    public FormattingException(final Throwable cause) {
        super(cause);
    }
}
