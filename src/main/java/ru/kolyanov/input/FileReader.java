package ru.kolyanov.input;

import java.io.*;

/**
 * this class contain methods for reading data from file
 */
public class FileReader extends BaseReader {

    private File file;
    /**
     * constructor
     * @param filename name of reading file
     * @throws ReaderException if file not found
     */
    public FileReader(final String filename) throws ReaderException {
        try {
            file = new File(filename);
            inputStream = new FileInputStream(file);
            buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
        } catch (FileNotFoundException e) {
            throw new ReaderException(e);
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

}
