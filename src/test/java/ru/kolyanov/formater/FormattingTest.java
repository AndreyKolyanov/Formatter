package ru.kolyanov.formater;

import org.junit.Test;
import ru.kolyanov.input.IReader;
import ru.kolyanov.input.ReaderException;
import ru.kolyanov.input.StringReader;
import ru.kolyanov.output.StringWriter;

import static junit.framework.Assert.assertEquals;

public class FormattingTest {

    @Test
    public void testFormatting() throws FormattingException, ReaderException {
        IReader reader = new StringReader("class Main {asd;asdaa;asd;}");
        StringWriter writer = new StringWriter();
        IFormatter formatter = new Formatter();
        formatter.format(reader, writer);
        assertEquals("fail","class Main {\n    asd;\n    asdaa;\n    asd;\n}\n", writer.getLines());
        System.out.println(writer.getLines());
    }
}
