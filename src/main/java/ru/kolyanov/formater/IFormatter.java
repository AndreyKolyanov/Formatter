package ru.kolyanov.formater;

import ru.kolyanov.input.IReader;
import ru.kolyanov.input.ReaderException;
import ru.kolyanov.output.IWriter;

/**
 * interface for formater
 */
public interface IFormatter {

    /**
     * for formater input data
     * @param reader for getting input data
     * @param writer  for writing of formatted data
     * @throws FormattingException if there is an error
     */
    void format(final IReader reader, final IWriter writer) throws FormattingException, ReaderException;
}
