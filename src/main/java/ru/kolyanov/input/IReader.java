package ru.kolyanov.input;

/**
 * interface for input
 */
public interface IReader {

    /**
     * It move to the next character
     * @return next symbol and remove from stream
     * @throws ReaderException to describe exceptions
     */

    int getSymbol() throws ReaderException;

    /**
     * method It does not move to the next character
     * @return next symbol from stream
     * @throws ReaderException to describe exceptions
     */
    int nextSymbol() throws ReaderException;
}
