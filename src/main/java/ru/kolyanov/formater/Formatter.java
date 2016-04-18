package ru.kolyanov.formater;

import ru.kolyanov.input.IReader;
import ru.kolyanov.input.ReaderException;
import ru.kolyanov.output.IWriter;
import ru.kolyanov.output.WritingException;

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
        Table table = new Table();
        while (true) {
            try {
                char symbol = reader.getSymbol();
                writer.printLine(symbol + table.encode(symbol));
            } catch (ReaderException e) {
                break;
            } catch (WritingException e) {
                e.printStackTrace();
            }
        }
    }
}
