package ru.kolyanov.input;

/**
 * interface for input
 */
public interface IReader {

    /**
     *
     * @return next symbol from stream
     * @throws ReaderException to describe exceptions
     */

    char getSymbol() throws ReaderException;
}
