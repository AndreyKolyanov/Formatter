package ru.kolyanov.input;

/**
 * this class contain methods for reading data from string
 */
public class StringReader implements IReader {

    private char[] string;
    private int nextSymbol;

    /**
     * constructor
     * @param string input data
     */
    public StringReader(final String string) {
        this.string = string.toCharArray();
        this.nextSymbol = 0;
    }

    /**
     * method for get single symbol from string
     * @return next symbol from string
     * @throws ReaderException in the case of reaching end of line
     */
    public char getSymbol() throws ReaderException {
        try {
            char symbol = string[nextSymbol];
            nextSymbol++;
            return symbol;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ReaderException(e);
        }
    }
}
