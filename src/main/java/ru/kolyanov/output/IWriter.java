package ru.kolyanov.output;

/**
 * interface for writing formatted data
 */
public interface IWriter {
    /**
     * method is write single line
     * @param string writable string
     * @throws WritingException if there is an error
     */
    void printLine(String string) throws WritingException;
}