package ru.kolyanov.input;

import java.io.InputStream;

/**
 * this class contain methods for reading data
 */
public abstract class BaseReader implements IReader {
    /**
     * the field buffer for read
     */
    protected byte[] buffer;
    private int nextSymbol;
    /**
     * input stream may be used for string reader or file reader
     */
    protected InputStream inputStream;

    /**
     * method for get single symbol from string or file
     * @return next symbol from string
     * @throws ReaderException in the case of reaching end of line
     */
    public int getSymbol() throws ReaderException {
        try {
            char symbol = (char) buffer[nextSymbol];
            nextSymbol++;
            return (int) symbol;
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }
    /**
     * It does not move to the next character
     * @return next symbol from string
     * @throws ReaderException in the case of reaching end of line
     */
    public int nextSymbol() throws ReaderException {
        try {
            char symbol = (char) buffer[nextSymbol];
            return (int) symbol;
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }
}
