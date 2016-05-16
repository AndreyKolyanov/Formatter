package ru.andrewkolyanov.output;

import java.io.IOException;

/**
 * this class provide writing formatted data
 */
public class StringWriter implements IWriter {

    private StringBuilder data;

    /**
     * constructor
     */
    public StringWriter() {
        data = new StringBuilder();
    }
    /**
     * method writing data
     * @param string writable string
     * @throws WritingException if there is an error
     */
    public void printLine(final String string) throws WritingException {
            data.append(string);
    }

    /**
     * method return formatted lines
     * @return data
     */
    public String getLines() {
        return data.toString();
    }

    @Override
    public void write() throws WritingException {
        System.out.println(data);
    }

    @Override
    public void close() throws IOException {
        data = null;
    }
}
