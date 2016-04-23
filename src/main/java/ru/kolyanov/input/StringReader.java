package ru.kolyanov.input;

import java.io.IOException;
import java.io.StringBufferInputStream;

/**
 * this class contain methods for reading data from string
 */
public class StringReader extends BaseReader {

    /**
     * constructor
     * @param data the input string
     * @throws ReaderException if file not found
     */
    public StringReader(final String data) throws ReaderException {
        inputStream = new StringBufferInputStream(data);
        try {
            buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
        } catch (IOException e) {
            throw new ReaderException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new ReaderException(e);
            }
        }
    }
}
