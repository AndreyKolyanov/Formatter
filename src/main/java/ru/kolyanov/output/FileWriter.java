package ru.kolyanov.output;

import java.io.*;

/**
 * class contain methods for write in file
 */
public class FileWriter implements IWriter {

    private StringBuilder data;
    private String filename;
    /**
     * constructor
     * @param filename name of writable file
     */
    public FileWriter(final String filename) {
        this.filename = filename;
        data = new StringBuilder();
    }
    /**
     * method writing data
     * @param string writable string
     */
    public void printLine(final String string) {
        data.append(string);
        data.append("\n");

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
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(filename)) {
            fileWriter.append(data);
        } catch (IOException e) {
            throw new WritingException(e);
        }
    }
}
