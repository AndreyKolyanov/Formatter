package ru.kolyanov.formater;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kolyanov.input.IReader;
import ru.kolyanov.input.ReaderException;
import ru.kolyanov.output.IWriter;
import ru.kolyanov.output.WritingException;
import ru.kolyanov.tables.*;


/**
 * class for formatter
 */
public class Formatter implements IFormatter {

    private INewLineTable newLineTable;
    private IOffsetTable offsetTable;
    /**
     * logger
     */
     final static Logger logger =  LoggerFactory.getLogger(Formatter.class);
    /**
     * constructor
     * @param newLineTable table for make new line
     * @param offsetTable table for make offset
     */
    public Formatter(final INewLineTable newLineTable, final IOffsetTable offsetTable) {
        this.newLineTable = newLineTable;
        this.offsetTable = offsetTable;
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
                while (reader.nextSymbol() != -1) {
                    char symbol = (char) reader.getSymbol();
                    buffer.append(symbol);
                    if (newLineTable.get(symbol)) {
                        writer.printLine(offsetTable.calculateOffset(buffer.toString()));
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
                throw new FormattingException(e);
            } catch (WritingException e) {
                if (logger.isErrorEnabled()) {
                    logger.error("Writing error: " + e.getMessage());
                }
                throw new FormattingException(e);
            }
    }
}
