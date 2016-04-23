package ru.kolyanov.output;

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
            data.append("\n");
    }

    /**
     * method return formatted lines
     * @return data
     */
    public String getLines() {
        return data.toString();
    }
}
