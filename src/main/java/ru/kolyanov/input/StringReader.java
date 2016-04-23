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
    public int getSymbol() throws ReaderException {
        try {
            char symbol = string[nextSymbol];
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
            char symbol = string[nextSymbol];
            return (int) symbol;
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }
}
