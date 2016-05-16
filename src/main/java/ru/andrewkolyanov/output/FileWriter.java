package ru.andrewkolyanov.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * class contain methods for write in file
 */
public class FileWriter implements IWriter {

    private java.io.FileWriter fileWriter;
    private StringBuilder data;
    private String filename;
    private Logger logger = LoggerFactory.getLogger(FileWriter.class);
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
     * @throws WritingException if empty string
     */
    public void printLine(final String string) throws WritingException {
        try {
            data.append(string);
        } catch (NullPointerException e) {
            throw new WritingException(e);
        }
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
        try {
            fileWriter = new java.io.FileWriter(filename);
            fileWriter.append(data);
        } catch (IOException e) {
            throw new WritingException(e);
        }
    }

    @Override
    public void close() throws IOException {
        fileWriter.close();
        logger.info("Save file: " + filename);
    }
}
