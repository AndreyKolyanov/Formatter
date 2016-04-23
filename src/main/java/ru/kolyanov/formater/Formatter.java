package ru.kolyanov.formater;

import ru.kolyanov.input.IReader;
import ru.kolyanov.input.ReaderException;
import ru.kolyanov.output.IWriter;
import ru.kolyanov.output.WritingException;
import ru.kolyanov.tables.*;

/**
 * class for formater
 */
public class Formatter implements IFormatter {
    /**
     * method provide formater input data
     * @param reader for getting input data
     * @param writer for writing of formatted data
     * @throws FormattingException if there is an error
     */
    public void format(final IReader reader, final IWriter writer) throws FormattingException {
        INewLineTable table = new FixedNewLineTable();
        IOffsetTable offsetTable = new FixedOffsetTable();
        StringBuilder buffer = new StringBuilder();
            try {
                while (reader.nextSymbol() != -1) {
                    char symbol = (char) reader.getSymbol();
                    buffer.append(symbol);
                    if (table.get(symbol)) {
                        writer.printLine(offsetTable.calculateOffset(buffer.toString()));
                        buffer.delete(0, buffer.length());
                    }
                }
            } catch (OffsetException e) {
                throw new FormattingException(e);
            } catch (ReaderException e) {
                throw new FormattingException(e);
            } catch (WritingException e) {
                throw new FormattingException(e);
            }
    }
}
