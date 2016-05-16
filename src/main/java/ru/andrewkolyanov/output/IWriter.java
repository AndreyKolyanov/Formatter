package ru.andrewkolyanov.output;

import java.io.Closeable;
import java.io.IOException;

/**
 * interface for writing formatted data
 */
public interface IWriter extends Closeable {
    /**
     * method is write single line
     * @param string writable string
     * @throws WritingException if there is an error
     */
    void printLine(String string) throws WritingException;
    /**
     * method return formatted lines
     * @return data
     */
    String getLines();

    /**
     * method write strings in file
     * @throws WritingException if there is an error
     */
    void write() throws WritingException;

    @Override
    void close() throws IOException;
}
