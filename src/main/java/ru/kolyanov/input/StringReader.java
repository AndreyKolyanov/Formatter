package ru.kolyanov.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

/**
 * this class contain methods for reading data from string
 */
public class StringReader implements IReader {

    private InputStream inputStream;
    /**
     * constructor
     * @param data the input string
     * @throws ReaderException if file not found
     */
    public StringReader(final String data) {
        inputStream = new StringBufferInputStream(data);
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
