package ru.kolyanov.bootstrap;

import ru.kolyanov.formater.Formatter;
import ru.kolyanov.formater.FormattingException;
import ru.kolyanov.input.FileReader;
import ru.kolyanov.input.IReader;
import ru.kolyanov.input.ReaderException;
import ru.kolyanov.input.StringReader;
import ru.kolyanov.output.FileWriter;
import ru.kolyanov.output.IWriter;
import ru.kolyanov.output.StringWriter;
import ru.kolyanov.output.WritingException;

import java.util.IllegalFormatException;

/**
 * bootstrap class
 */
public class Bootstrap {


    /**
     * constructor
     */
    private Bootstrap(){}

    /**
     * run point
     * @param args arguments commandline
     * @throws ReaderException if exception happened
     * @throws WritingException if exception happened
     * @throws FormattingException if exception happened
     */
    public static void main(final String[] args) throws ReaderException, FormattingException, WritingException {
        IReader reader = null;
        IWriter writer = null;
        if (args != null) {
            if (args[0].equals("-f")) {
                if ((args[1] != null) && (args[2] != null)) {
                    reader = new FileReader(args[1]);
                    writer = new FileWriter(args[2]);
                } else {
                    using();
                }
            }
            if (args[0].equals("-s")) {
                if (args[1] != null) {
                    reader  = new StringReader(args[1]);
                    writer = new StringWriter();
                } else {
                    using();
                }
            }
        } else {
            using();
        }

        Formatter formatter = new Formatter();
        formatter.format(reader, writer);
        writer.write();
    }
    private static void using() throws ReaderException {
        System.out.println("Using -f <input file> <output file> for files\n      -s <string> for using string");
        throw new ReaderException(new IllegalArgumentException("Illegal arguments"));
    }
}
