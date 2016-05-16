package ru.andrewkolyanov.bootstrap;

import ru.andrewkolyanov.machine.FormattingException;
import ru.andrewkolyanov.input.FileReader;
import ru.andrewkolyanov.input.IReader;
import ru.andrewkolyanov.input.ReaderException;
import ru.andrewkolyanov.input.StringReader;
import ru.andrewkolyanov.machine.IndentCounter;
import ru.andrewkolyanov.machine.Machine;
import ru.andrewkolyanov.machine.tables.OutputTable;
import ru.andrewkolyanov.machine.tables.TransitionTable;
import ru.andrewkolyanov.output.FileWriter;
import ru.andrewkolyanov.output.IWriter;
import ru.andrewkolyanov.output.StringWriter;
import ru.andrewkolyanov.output.WritingException;

import java.io.IOException;


/**
 * bootstrap class
 */
public final class Bootstrap {


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
    public static void main(final String[] args) throws ReaderException, FormattingException, WritingException, IOException {
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

        IndentCounter indentCounter = new IndentCounter();
        Machine formatter = new Machine(new TransitionTable(), new OutputTable(indentCounter), indentCounter);
        formatter.format(reader, writer);
        writer.write();
        writer.close();
    }
    private static void using() throws ReaderException {
        System.out.println("Using -f <input file> <output file> for files\n      -s <string> for using string");
        throw new ReaderException(new IllegalArgumentException("Illegal arguments"));
    }
}
