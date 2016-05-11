package ru.kolyanov.input;

import java.io.*;

/**
 * this class contain methods for reading data from file
 */
public class FileReader implements IReader {


    private InputStream inputStream;
    /**
     * constructor
     * @param filename name of reading file
     * @throws ReaderException if file not found
     */
    public FileReader(final String filename) throws ReaderException {
        try {
            File file = new File(filename);
            inputStream = new FileInputStream(file);
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public int getSymbol() throws ReaderException {
        try {
            int code = inputStream.read();
            if (code == -1){
                throw new ReaderException(new Exception("End o file"));
            }
            return code;
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
