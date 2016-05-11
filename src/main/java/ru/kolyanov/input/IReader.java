package ru.kolyanov.input;

import java.io.Closeable;
import java.io.IOException;

/**
 * interface for input
 */
public interface IReader extends Closeable {

    /**
     * It move to the next character
     * @return next symbol and remove from stream
     * @throws ReaderException to describe exceptions
     */

    int getSymbol() throws ReaderException;

    @Override
    void close() throws IOException;
}
