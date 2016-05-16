package ru.andrewkolyanov.machine;

import org.junit.Test;
import ru.andrewkolyanov.input.ReaderException;
import ru.andrewkolyanov.input.StringReader;
import ru.andrewkolyanov.machine.tables.OutputTable;
import ru.andrewkolyanov.machine.tables.TransitionTable;
import ru.andrewkolyanov.output.IWriter;
import ru.andrewkolyanov.output.StringWriter;

import static junit.framework.Assert.assertEquals;

public class MachineTests {



    @Test
    public void testMachine() throws ReaderException, FormattingException {
        IWriter writer = new StringWriter();
        IndentCounter indentCounter = new IndentCounter();
        Machine machine = new Machine(new TransitionTable(), new OutputTable(indentCounter), indentCounter);
        machine.format(new StringReader("ssss{ss;sss;}"), writer);
        assertEquals("fail", "ssss{\n    ss;\n    sss;\n}", writer.getLines());
    }

    @Test
    public void testMachine2() throws ReaderException, FormattingException {
        IWriter writer = new StringWriter();
        IndentCounter indentCounter = new IndentCounter();
        Machine machine = new Machine(new TransitionTable(), new OutputTable(indentCounter), indentCounter);
        machine.format(new StringReader("{dfg;hgfh;{dldl;wer;}}"), writer);
        assertEquals("fail", "{\n    dfg;\n    hgfh;\n    {\n        dldl;\n        wer;\n    }\n}", writer.getLines());
    }
}
