package ru.kolyanov.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kolyanov.input.IReader;
import ru.kolyanov.input.ReaderException;
import ru.kolyanov.output.IWriter;
import ru.kolyanov.output.WritingException;
import ru.kolyanov.tables.*;

import java.io.IOException;


/**
 * class for formatter
 */
public class Formatter implements IFormatter {

    private INewLineTable newLineTable;
    private OffsetCalculator offsetCalculator;
    /**
     * logger
     */
     final static Logger logger =  LoggerFactory.getLogger(Formatter.class);
    /**
     * constructor
     * @param newLineTable table for make new line
     * @param offsetCalculator table for make offset
     */
    public Formatter(final INewLineTable newLineTable, final OffsetCalculator offsetCalculator) {
        this.newLineTable = newLineTable;
        this.offsetCalculator = offsetCalculator;
    }
    /**
     * method provide formatter input data
     * @param reader for getting input data
     * @param writer for writing of formatted data
     * @throws FormattingException if there is an error
     */
    public void format(final IReader reader, final IWriter writer) throws FormattingException {

        StringBuilder buffer = new StringBuilder();
            try {
                while (true) {
                    char symbol = (char) reader.getSymbol();
                    buffer.append(symbol);
                    if (newLineTable.get(symbol)) {
                        writer.printLine(offsetCalculator.calculateOffset(buffer.toString()));
                        buffer.delete(0, buffer.length());
                    }
                }
            } catch (OffsetException e) {
                if (logger.isErrorEnabled()) {
                    logger.error("An error in the calculation of the indentation: " + e.getMessage());
                }
                throw new FormattingException(e);
            } catch (ReaderException e) {
                if (logger.isErrorEnabled()) {
                    logger.error("Reading error: " + e.getMessage());
                }
            } catch (WritingException e) {
                if (logger.isErrorEnabled()) {
                    logger.error("Writing error: " + e.getMessage());
                }
                throw new FormattingException(e);
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new FormattingException(e);
                }
            }
    }
}
